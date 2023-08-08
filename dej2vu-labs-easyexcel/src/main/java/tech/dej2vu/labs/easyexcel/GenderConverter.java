package tech.dej2vu.labs.easyexcel;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * @author dej2vu
 * @date 2023/08/07
 */
public class GenderConverter implements Converter<Gender> {

    @Override
    public Gender convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) {
        String stringValue = cellData.getStringValue();
        return Gender.descOf(stringValue);
    }

}
