package com.hamtaro.barcode.ux;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.web.js.BJsBuild;

@NiagaraType
/**
 * BBarcodeJsBuild maps the barcode module to the minifies JavaScript file for Bajaux.
 */
public class BBarcodeJsBuild extends BJsBuild
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.rus.barcode.ux.BBarcodeJsBuild(2979906276)1.0$ @*/
/* Generated Thu Dec 19 11:05:35 ICT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type



  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    public static final BBarcodeJsBuild INSTANCE = new BBarcodeJsBuild(
            "barcode",
            new BOrd[] {
                    BOrd.make("module://barcode/rc/barcode.built.min.js")
            }
            // If a new Type[] is needed here, enable the 3-argument constructor
    );


    //  private BBarcodeJsBuild(String id, BOrd[] files, Type[] deps) {
//    super(id, files, deps);
//  }
    private BBarcodeJsBuild(String id, BOrd[] files) {
        super(id, files);
    }

    @Override
    public Type getType() { return TYPE; }
    public static final Type TYPE = Sys.loadType(BBarcodeJsBuild.class);
}
