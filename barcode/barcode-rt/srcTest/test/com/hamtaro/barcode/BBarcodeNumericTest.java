package test.com.hamtaro.barcode;

import com.hamtaro.barcode.BBarcodeNumeric;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatusNumeric;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

@NiagaraType

public class BBarcodeNumericTest
        extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.rus.barcode.BBarcodeNumericTest(2979906276)1.0$ @*/
/* Generated Fri Dec 20 09:39:43 ICT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BBarcodeNumericTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    @Test(expectedExceptions = NullPointerException.class)
    public void nullImage()
    {
        BBarcodeNumeric bcn = new BBarcodeNumeric();
        bcn.setOut(null);
        String image = bcn.getImageBuffer();
    }

    // test with multiple value for multiple test cases and coverage
    @Test(dataProvider = "valueProvider")
    public void generateImage(Double out)
    {
        BBarcodeNumeric bcn = new BBarcodeNumeric();
        // set out slot value with value from argument
        bcn.setOut(new BStatusNumeric(out.doubleValue()));
        String image = bcn.getImageBuffer();

        // check not null
        Assert.assertNotNull(image);
    }

    @DataProvider(name="valueProvider")
    public Object[][] valueProvider()
    {
        return new Object[][] {
                { new Double(0) },
                { new Double(-100) },
                { new Double(200) },
                { new Double(123.766) }
        };
    }
}
