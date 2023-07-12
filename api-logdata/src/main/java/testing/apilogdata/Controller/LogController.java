package testing.apilogdata.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testing.apilogdata.Dto.LogDTO;
import testing.apilogdata.Service.LogService;

import java.util.List;
@RestController

public class LogController {
    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }


    @GetMapping("/log")
    public List<LogDTO> getAllLogs() {
        return logService.getAllLogs();
    }

//@RestController
//@RequestMapping("/api/logs")
//public class LogContrroller {
//    private final LogService logService;
//
//    public LogContrroller(LogService logService) {
//        this.logService = logService;
//    }
//
//
//    @GetMapping("/user/{user}")
//    public List<Logs> getLogsByUser(@PathVariable String user) {
//        return logService.getLogsByUser(user);
//    }
//@GetMapping
//public List<Logs> getAllLogs() {
//    return logService.getAllLogs();
//}
}
