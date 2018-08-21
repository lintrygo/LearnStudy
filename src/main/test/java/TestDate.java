import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDateTime;

@Slf4j
public class TestDate {

    @Test
    public void TestLocalDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        log.info("testLocalDateTime");
    }
}
