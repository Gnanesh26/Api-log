package testing.apilogdata.Controller;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private Bucket bucket;


    @GetMapping("/token-generate")
    public ResponseEntity<String> generateToken(){
        Refill refill = Refill.of(5,Duration.ofMinutes(1));
      bucket=Bucket4j.builder().addLimit(Bandwidth.classic(5,refill)).build();
        return new ResponseEntity<String>("Generated Successfully |||"+bucket.toString(),HttpStatus.OK);
    }



    @GetMapping("/demo")
    public ResponseEntity<String> demo(){
        if(bucket.tryConsume(1)) {
System.out.println("---------------API WORKING SUCCESSFULLY---------------");

            return new ResponseEntity<String>("Success", HttpStatus.OK);
        }
        System.out.println("---------------NUMBER OF HiTS EXCEEDED");
        return new ResponseEntity<String>("TOO MANY HITS !!! PLEASE TRY LATER",HttpStatus.TOO_MANY_REQUESTS);

    }

//    private final Bucket bucket;
//
    public LogController() {
        Bandwidth limit = Bandwidth.classic(5, Refill.greedy(5, Duration.ofMinutes(2)));
        this.bucket = Bucket4j.builder()
                .addLimit(limit)
                .build();
    }
//
//
    @GetMapping("/log")
    public ResponseEntity<List<LogDTO>> getAllLogs() {
        if (bucket.tryConsume(1)) {
            List<LogDTO> logs = logService.getAllLogs();

            return ResponseEntity.ok(logs);
        } else {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
        }
    }
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
}
