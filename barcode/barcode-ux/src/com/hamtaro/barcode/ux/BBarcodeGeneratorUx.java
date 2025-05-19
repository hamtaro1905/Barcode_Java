package com.hamtaro.barcode.ux;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BSingleton;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.web.BIFormFactorMini;
import javax.baja.web.js.BIJavaScript;
import javax.baja.web.js.JsInfo;

import java.lang.Override;
import java.text.DecimalFormat;

@NiagaraType(
        agent= {
                @AgentOn(types="barcode:BarcodeNumeric")
        }
)
@NiagaraSingleton
/**
 * BBarcodeGeneratorUx is a required singleton class for implementing the bajaux field editor.
 */
public class BBarcodeGeneratorUx
        extends BSingleton
        implements BIJavaScript, BIFormFactorMini
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.rus.barcode.ux.BBarcodeGeneratorUx(2790003492)1.0$ @*/
/* Generated Thu Dec 19 11:08:27 ICT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  public static final BBarcodeGeneratorUx INSTANCE = new BBarcodeGeneratorUx();

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BBarcodeGeneratorUx.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/



    @Override
    public JsInfo getJsInfo(Context cx) {
        return JS_INFO;
    }

    private static final JsInfo JS_INFO = JsInfo.make(
            BOrd.make("module://barcode/rc/BarcodeGeneratorUx.js"),
            BBarcodeJsBuild.TYPE
    );

    private static DecimalFormat df3 = new DecimalFormat("000.000");
}
