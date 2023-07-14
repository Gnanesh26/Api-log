package testing.apilogdata.Controller;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import testing.apilogdata.Dto.LogDTO;
import testing.apilogdata.Service.LogService;

import java.time.Duration;
import java.util.List;


@RestController
public class LogController {
    @Autowired
    LogService logService;

    private static final int ACCESS_LIMIT = 5;
    private static final long TWO_MINUTES_IN_MILLISECONDS = 2* 60 * 1000;
    private Bucket requestBucket;

    public LogController() {
        Bandwidth limit = Bandwidth.classic(ACCESS_LIMIT, Refill.intervally(ACCESS_LIMIT, Duration.ofMinutes(5)));
        this.requestBucket = Bucket4j.builder().addLimit(limit).build();
    }

    @GetMapping("/log")
    public ResponseEntity<Object> getAllLogs() {
        if (exceededAccessLimit()) {
            String message = "Access limit exceeded. Please try again later.";
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(message);
        } else {
            List<LogDTO> logs = logService.getAllLogs();
            return ResponseEntity.ok(logs);
        }
    }

    private boolean exceededAccessLimit() {
        return !requestBucket.tryConsume(1);
    }
}

//@RestController
//
//public class LogController {
//    @Autowired
//    LogService logService;
//    private static final int ACCESS_LIMIT = 2;
//    private int accessCount = 0;
//
//    @GetMapping("/log")
//    public ResponseEntity<Object> getAllLogs() {
//        if (accessCount < ACCESS_LIMIT) {
//            accessCount++;
//            List<LogDTO> logs = logService.getAllLogs();
//            return ResponseEntity.ok(logs);
//        } else {
//            String message = "Access limit exceeded";
//            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(message);
//        }
//    }
//}
//@RestController
//
//public class LogController {
//    @Autowired
//    LogService logService;

//    @GetMapping("/log")
//    public List<LogDTO> getAllLogs() {
//        return logService.getAllLogs();
//    }
////
//}
//}
