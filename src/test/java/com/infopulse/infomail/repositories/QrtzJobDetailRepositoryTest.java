package com.infopulse.infomail.repositories;

import com.infopulse.infomail.dto.api.schedule.ScheduledTaskWithEmailDTO;
import com.infopulse.infomail.dto.app.ScheduledTaskRaw;
import com.infopulse.infomail.models.quartz.QrtzJobDetail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class QrtzJobDetailRepositoryTest {

    @Autowired
    private QrtzJobDetailRepository qrtzJobDetailRepository;

    private final String DISABLE_REASON = "Disabled because jobName was obtained from an existing database, " +
            "if you specify the actual 'jobName' and 'jobGroup' values, then you can remove the annotation";
    private final String jobName = "10414bad-49cb-4679-b1e0-193dee6c29e7";
    private final String jobGroup = "admin@infomail.com";

    @Disabled(DISABLE_REASON)
    @Test
    void getDTOByJobName_thenIsPresent() {
        Optional<ScheduledTaskRaw> dtoByJobName = qrtzJobDetailRepository.getDTOByJobName(jobName, jobGroup);

        assertTrue(dtoByJobName.isPresent());
        ScheduledTaskWithEmailDTO scheduledTaskWithEmailDTO = new ScheduledTaskWithEmailDTO(dtoByJobName.get(), null);
        System.out.println("scheduledTaskFullDTO = " + scheduledTaskWithEmailDTO);

    }

    @Test
    void getDTOByJobName_thenNotPresent() {
        Optional<ScheduledTaskRaw> dtoByJobName = qrtzJobDetailRepository.getDTOByJobName("not found job name", "not found job group");

        assertFalse(dtoByJobName.isPresent());
    }

    @Disabled(DISABLE_REASON)
    @Test
    void findByJobName() {
        Optional<QrtzJobDetail> jobDetail = qrtzJobDetailRepository.findByJobName(jobName);

        assertTrue(jobDetail.isPresent());

    }
}
