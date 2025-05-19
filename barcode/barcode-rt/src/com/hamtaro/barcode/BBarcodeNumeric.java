package com.hamtaro.barcode;

import javax.baja.control.BNumericWritable;
import javax.baja.sys.Context;
import javax.baja.sys.Flags;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.sys.BBlob;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import java.io.ByteArrayOutputStream;
import java.lang.Override;
import java.text.DecimalFormat;
import java.util.logging.Logger;

import org.krysalis.barcode4j.BarcodeDimension;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

@NiagaraType
@NiagaraProperty(name="imageBuffer", type="String", defaultValue="", flags= Flags.READONLY)
@NiagaraProperty(name="barcodeWidth", type="double", defaultValue="0", flags= Flags.READONLY)
@NiagaraProperty(name="barcodeHeight", type="double", defaultValue="0", flags= Flags.READONLY)
@NiagaraProperty(name="logginEnabled", type="boolean", defaultValue="false")

/**
 * BBarcodeNumeric generates a barcode image of a numeric point value and makes it available
 * as a Base64-encoded String prpoerty called "imageBuffer".
 */
public class BBarcodeNumeric
        extends BNumericWritable
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.hamtaro.barcode.BBarcodeNumeric(2564419215)1.0$ @*/
/* Generated Sat May 17 16:27:33 ICT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "imageBuffer"

  /**
   * Slot for the {@code imageBuffer} property.
   * @see #getImageBuffer
   * @see #setImageBuffer
   */
  public static final Property imageBuffer = newProperty(Flags.READONLY, "", null);

  /**
   * Get the {@code imageBuffer} property.
   * @see #imageBuffer
   */
  public String getImageBuffer() { return getString(imageBuffer); }

  /**
   * Set the {@code imageBuffer} property.
   * @see #imageBuffer
   */
  public void setImageBuffer(String v) { setString(imageBuffer, v, null); }

  //endregion Property "imageBuffer"

  //region Property "barcodeWidth"

  /**
   * Slot for the {@code barcodeWidth} property.
   * @see #getBarcodeWidth
   * @see #setBarcodeWidth
   */
  public static final Property barcodeWidth = newProperty(Flags.READONLY, 0, null);

  /**
   * Get the {@code barcodeWidth} property.
   * @see #barcodeWidth
   */
  public double getBarcodeWidth() { return getDouble(barcodeWidth); }

  /**
   * Set the {@code barcodeWidth} property.
   * @see #barcodeWidth
   */
  public void setBarcodeWidth(double v) { setDouble(barcodeWidth, v, null); }

  //endregion Property "barcodeWidth"

  //region Property "barcodeHeight"

  /**
   * Slot for the {@code barcodeHeight} property.
   * @see #getBarcodeHeight
   * @see #setBarcodeHeight
   */
  public static final Property barcodeHeight = newProperty(Flags.READONLY, 0, null);

  /**
   * Get the {@code barcodeHeight} property.
   * @see #barcodeHeight
   */
  public double getBarcodeHeight() { return getDouble(barcodeHeight); }

  /**
   * Set the {@code barcodeHeight} property.
   * @see #barcodeHeight
   */
  public void setBarcodeHeight(double v) { setDouble(barcodeHeight, v, null); }

  //endregion Property "barcodeHeight"

  //region Property "logginEnabled"

  /**
   * Slot for the {@code logginEnabled} property.
   * @see #getLogginEnabled
   * @see #setLogginEnabled
   */
  public static final Property logginEnabled = newProperty(0, false, null);

  /**
   * Get the {@code logginEnabled} property.
   * @see #logginEnabled
   */
  public boolean getLogginEnabled() { return getBoolean(logginEnabled); }

  /**
   * Set the {@code logginEnabled} property.
   * @see #logginEnabled
   */
  public void setLogginEnabled(boolean v) { setBoolean(logginEnabled, v, null); }

  //endregion Property "logginEnabled"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BBarcodeNumeric.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
@Override
public void changed(Property prop, Context cx)
{
    // Update the barcode imageBuffer value
    try
    {
        //Create the barcode bean
        Code39Bean bean = new Code39Bean();

        //Configure the barcode generator
        final int dpi = 150;
        bean.setModuleWidth(UnitConv.in2mm(1.0f / dpi)); //makes the narrow bar width exactly one pixel
        bean.setWideFactor(3); // narrow bar * {wide factor value}
        bean.doQuietZone(false); // set blank space around barcode to false (padding-left-right)

        //Initialize the text for the barcode
        String barcodeText = df3.format(getOut().getValue());

        //Set up the barcode canvas provider for monochrome (grey scale) JPEG output
        ByteArrayOutputStream out = new ByteArrayOutputStream(8192); // 8 KB
        BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                out, "image/jpeg", dpi, 12, false, 0); //  BufferedImage.TYPE_BYTE_BINARY not part of compact3

        //Generate the barcode
        bean.generateBarcode(canvas, barcodeText);

        //Signal end of generation
        canvas.finish();

        // Set size properties
        BarcodeDimension size = bean.calcDimensions(barcodeText);
        setBarcodeWidth(size.getWidth());
        setBarcodeHeight(size.getHeight());

        // log permission
        if (getLogginEnabled())
        {
            log.info("generating barcode for " + barcodeText +
                    ", size=(" + getBarcodeWidth() + "," + getBarcodeHeight() + ")");
        }


        BBlob byteArray = BBlob.make(out.toByteArray());
        setImageBuffer(byteArray.encodeToString());
    }
    catch (Exception e) {
        e.printStackTrace();
    }
}

    public static final Logger log = Logger.getLogger("barcode");
    public static DecimalFormat df3 = new DecimalFormat("000.000");
}

