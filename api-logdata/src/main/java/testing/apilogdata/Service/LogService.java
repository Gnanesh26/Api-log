package testing.apilogdata.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testing.apilogdata.Dto.LogDTO;
import testing.apilogdata.Entity.Logs;
import testing.apilogdata.Repository.LogRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogService {
    @Autowired
     LogRepository logRepository;



    public List<LogDTO> getAllLogs() {
        List<Logs> logEntries = logRepository.findAll();
        List<LogDTO> logEntryDTOs = new ArrayList<>();

        for (Logs logEntry : logEntries) {
            LogDTO logEntryDTO = new LogDTO();

            logEntryDTO.setUser(logEntry.getUser());
            logEntryDTO.setRole(logEntry.getRole());
            logEntryDTO.setRequestUrl(logEntry.getRequestUrl());
            logEntryDTO.setHttpMethod(logEntry.getHttpMethod());
            logEntryDTO.setAccessCount(logEntry.getAccessCount());
            logEntryDTO.setLogTime(logEntry.getLogTime());
            logEntryDTOs.add(logEntryDTO);
        }

        return logEntryDTOs;
    }

}