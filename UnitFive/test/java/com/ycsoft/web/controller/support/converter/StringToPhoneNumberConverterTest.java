package com.ycsoft.web.controller.support.converter;

import com.ycsoft.model.PhoneNumberModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.number.CurrencyFormatter;
import org.springframework.format.support.DefaultFormattingConversionService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Locale;

/**
 * StringToPhoneNumberConverter Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>01/18/2017</pre>
 */
public class StringToPhoneNumberConverterTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: convert(String source)
     */
    @Test
    public void testConvert() throws Exception {
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToPhoneNumberConverter());
        String phoneNumberStr = "010-12345678";
        PhoneNumberModel phoneNumber = conversionService.convert(phoneNumberStr, PhoneNumberModel.class);
        Assert.assertEquals("011", phoneNumber.getAreaCode());
    }

    @Test
    public void testOtherConvert() {
        DefaultConversionService conversionService = new DefaultConversionService();

        Assert.assertEquals(Boolean.valueOf(true), conversionService.convert("1", Boolean.class));

        Assert.assertEquals(4, conversionService.convert("1, 2, 3, 4", List.class).size());

    }

    @Test
    public void testWithDefaultFormattingConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        //默认不自动注册任何Formatter
        CurrencyFormatter currencyFormatter = new CurrencyFormatter();
        //保留小数点后几位
        currencyFormatter.setFractionDigits(2);
        //舍入模式（ceilling表示四舍五入）
        currencyFormatter.setRoundingMode(RoundingMode.CEILING);
        //注册Formatter SPI实现
        conversionService.addFormatter(currencyFormatter);

        LocaleContextHolder.setLocale(Locale.US);
        Assert.assertEquals("$1,234.13", conversionService.convert(new BigDecimal("1234.128"), String.class));

        LocaleContextHolder.setLocale(Locale.CHINA);
        Assert.assertEquals("￥1,234.13", conversionService.convert(new BigDecimal("1234.128"), String.class));
        Assert.assertEquals(new BigDecimal("1234.13"), conversionService.convert("￥1,234.13", BigDecimal.class));

        LocaleContextHolder.setLocale(null);
    }
} 
