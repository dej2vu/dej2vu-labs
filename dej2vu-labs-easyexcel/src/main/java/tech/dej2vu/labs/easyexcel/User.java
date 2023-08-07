package tech.dej2vu.labs.easyexcel;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import jdk.jfr.Experimental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @ExcelProperty(value = "昵称")
    private String username;

    @ExcelProperty(value = "性别", converter = GenderConverter.class)
    private Gender gender;

    @ExcelProperty(value = "出生日期")
    private LocalDate birthday;

    @ExcelProperty(value = "邮箱")
    private String mail;

    @ExcelProperty(value = "评分")
    private Integer score;

}
