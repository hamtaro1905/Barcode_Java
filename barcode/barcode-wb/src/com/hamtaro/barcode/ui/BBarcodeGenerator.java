package com.hamtaro.barcode.ui;

import javax.baja.gx.Graphics;
import javax.baja.gx.BImage;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.sys.BBlob;
import javax.baja.ui.BWidget;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;

import java.io.IOException;
import java.lang.Override;

@NiagaraType
@NiagaraProperty(name="imageBuffer", type="String", defaultValue="")
@NiagaraProperty(name="barcodeWidth", type="double", defaultValue="0")
@NiagaraProperty(name="barcodeHeight", type="double", defaultValue="0")

/**
 * BBarcodeGenerator displays the value of a BarcodeNumeric point as a barcode image widget.
 */
public class BBarcodeGenerator
        extends BWidget
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.rus.barcode.ui.BBarcodeGenerator(1306997285)1.0$ @*/
/* Generated Thu Dec 19 10:53:38 ICT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "imageBuffer"

  /**
   * Slot for the {@code imageBuffer} property.
   * @see #getImageBuffer
   * @see #setImageBuffer
   */
  public static final Property imageBuffer = newProperty(0, "", null);

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
  public static final Property barcodeWidth = newProperty(0, 0, null);

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
  public static final Property barcodeHeight = newProperty(0, 0, null);

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

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BBarcodeGenerator.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    public BBarcodeGenerator()  {  }

    @Override
    public void paint(Graphics g)
    {
        byte[] b = new byte[0];
        BBlob byteArray = BBlob.make(b);
        try
        {
            String resolvedImageBuffer = getImageBuffer();
            Double resolvedBarcodeWidth = getBarcodeWidth();
            Double resolvedBarcodeHeight = getBarcodeHeight();
            BBlob decodedBlob = (BBlob)byteArray.decodeFromString(resolvedImageBuffer);
            byte[] b2 = decodedBlob.copyBytes();
            g.drawImage(BImage.make(b2), resolvedBarcodeWidth, resolvedBarcodeHeight);
        }
        catch (IOException e)
        {
            // Do anything here?
        }

    }
}
