package tech.dej2vu.labs.easyexcel;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author dej2vu
 * @date 2023/08/07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

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
