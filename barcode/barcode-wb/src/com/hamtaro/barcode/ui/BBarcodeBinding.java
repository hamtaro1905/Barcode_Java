package com.hamtaro.barcode.ui;

import com.hamtaro.barcode.BBarcodeNumeric;
import javax.baja.nre.annotations.AgentOn;
import javax.baja.sys.BDouble;
import javax.baja.sys.BString;
import javax.baja.ui.BValueBinding;
import javax.baja.sys.BValue;
import javax.baja.sys.Property;
import javax.baja.sys.BObject;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

import javax.baja.nre.annotations.NiagaraType;

@NiagaraType(
        agent=@AgentOn(types={"barcode:BarcodeNumeric", "barcode:BarcodeGenerator"})
)

/**
 * BBarcodeBinding implements the binding between the BarcodeNumeric point and the BarcodeGenerator widget.
 */
public class BBarcodeBinding
        extends BValueBinding
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.rus.barcode.ui.BBarcodeBinding(557629789)1.0$ @*/
/* Generated Thu Dec 19 10:53:38 ICT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BBarcodeBinding.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    @Override
    public BValue getOnWidget(Property prop)
    {
        BObject from = get();
        if (from instanceof BBarcodeNumeric)
        {
            String name = prop.getName();
            if (name.equals("imageBuffer"))
            {
                return BString.make(((BBarcodeNumeric)from).getImageBuffer());
            }
            if (name.equals("barcodeHeight"))
            {
                return BDouble.make(((BBarcodeNumeric)from).getBarcodeHeight());
            }
            if (name.equals("barcodeWidth"))
            {
                return BDouble.make(((BBarcodeNumeric)from).getBarcodeWidth());
            }
        }
        return super.getOnWidget(prop);
    }
}
