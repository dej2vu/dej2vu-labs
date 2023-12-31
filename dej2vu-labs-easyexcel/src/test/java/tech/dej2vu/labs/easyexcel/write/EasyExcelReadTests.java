package tech.dej2vu.labs.easyexcel.write;

import com.alibaba.excel.EasyExcel;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.core.io.ClassPathResource;
import tech.dej2vu.labs.easyexcel.User;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Log4j2
public class EasyExcelReadTests {

    @ParameterizedTest
    @ValueSource(strings = "mock/LPL选手名单.xlsx")
    public void simple_read_file(String filename) throws IOException {

        File file = new ClassPathResource(filename).getFile();

        log.info("Start read to List<Object>...");
        List<Object> objects = EasyExcel.read(file).sheet().doReadSync();
        objects.forEach(log::info);
        log.info("End read to List<Object>...");

        log.info("Start read to List<Map<Integer, String>>...");
        List<Map<Integer, String>> maps = EasyExcel.read(file).sheet().doReadSync();
        maps.forEach(log::info);
        log.info("End read to List<Map<Integer, String>>...");


        log.info("Start read to List<User>...");
        List<User> users = EasyExcel.read(file).head(User.class).sheet().doReadSync();
        users.forEach(log::info);
        log.info("End read to List<User>...");
    }
}
