package testing.apilogdata.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import testing.apilogdata.Dto.LogDTO;
import testing.apilogdata.Service.LogService;

import java.util.List;
@RestController

public class LogController {
    @Autowired
    LogService logService;

    @GetMapping("/log")
    public List<LogDTO> getAllLogs() {
        return logService.getAllLogs();
    }

}
