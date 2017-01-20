package com.ycsoft.web.controller.support.formatter;

import com.ycsoft.model.FormatterModel;
import com.ycsoft.model.PhoneNumberModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.format.support.DefaultFormattingConversionService;

import java.util.Date;

/**
 * PhoneNumberFormatter Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>01/19/2017</pre>
 */
public class PhoneNumberFormatterTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: parse(String text, Locale locale)
     */
    @Test
    public void testParse() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: print(PhoneNumberModel object, Locale locale)
     */
    @Test
    public void testPrint() throws Exception {
//TODO: Test goes here... 
    }

    @Test
    public void test() throws Exception {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        conversionService.addFormatter(new PhoneNumberFormatter());

        PhoneNumberModel phoneNumber = new PhoneNumberModel("010", "12345678");
        Assert.assertEquals("010-12345678", conversionService.convert(phoneNumber, String.class));

        Assert.assertEquals("010", conversionService.convert("010-12345678", PhoneNumberModel.class).getAreaCode());

    }

    @Test
    public void testFormatter() throws Exception {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

        FormatterModel model = new FormatterModel();
        model.setTotalCount(10000);
        model.setDiscount(0.51);
        model.setSumMoney(10000.13);
        model.setRegisterDate(new Date(2012 - 1900, 4, 1));
        model.setOrderDate(new Date(2012 - 1900, 4, 1, 20, 18, 18));

        TypeDescriptor descriptor = new TypeDescriptor(FormatterModel.class.getDeclaredField("totalCount"));
        TypeDescriptor stringDescriptor = TypeDescriptor.valueOf(String.class);

        Assert.assertEquals("10,000", conversionService.convert(model.getTotalCount(), descriptor, stringDescriptor));
        Assert.assertEquals(model.getTotalCount(), conversionService.convert("10,000", stringDescriptor, descriptor));

        descriptor = new TypeDescriptor(FormatterModel.class.getDeclaredField("registerDate"));
        Assert.assertEquals("2012-05-01", conversionService.convert(model.getRegisterDate(), descriptor, stringDescriptor));
        Assert.assertEquals(model.getRegisterDate(), conversionService.convert("2012-05-01", stringDescriptor, descriptor));

        descriptor = new TypeDescriptor(FormatterModel.class.getDeclaredField("orderDate"));
        Assert.assertEquals("2012-05-01 20:18:18", conversionService.convert(model.getOrderDate(), descriptor, stringDescriptor));
        Assert.assertEquals(model.getOrderDate(), conversionService.convert("2012-05-01 20:18:18", stringDescriptor, descriptor));
    }

    @Test
    public void testFormatter2() throws Exception {
        //创建格式化服务
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
//添加自定义的注解格式化工厂
        conversionService.addFormatterForFieldAnnotation(new PhoneNumberFormatAnnotationFormatterFactory());

        FormatterModel model = new FormatterModel();

        TypeDescriptor descriptor = new TypeDescriptor(FormatterModel.class.getDeclaredField("phoneNumber"));
        TypeDescriptor stringDescriptor = TypeDescriptor.valueOf(String.class);

        //解析字符串"010-12345678"--> PhoneNumberModel
        PhoneNumberModel value = (PhoneNumberModel) conversionService.convert("010-12345678", stringDescriptor, descriptor);
        model.setPhoneNumber(value);

        //格式化PhoneNumberModel-->"010-12345678"
        Assert.assertEquals("010-12345678", conversionService.convert(model.getPhoneNumber(), descriptor, stringDescriptor));

    }

}
