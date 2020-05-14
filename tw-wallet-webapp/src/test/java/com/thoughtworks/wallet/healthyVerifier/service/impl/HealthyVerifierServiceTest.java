package com.thoughtworks.wallet.healthyVerifier.service.impl;

import com.thoughtworks.wallet.healthyVerifier.model.HealthyStatus;
import com.thoughtworks.wallet.healthyVerifier.model.HealthyStatusWrapper;
import com.thoughtworks.wallet.healthyVerifier.model.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest()
class HealthyVerifierServiceTest {

    @InjectMocks
    private HealthyVerifierService healthyVerifierService;

    @Mock
    private SuspectedPatientService suspectedPatientService;

    @Test
    public void should_be_unhealthy_when_temperature_is_38() {
        final Result noSymptoms = Result.NO;
        String healthyPhone = "healthy_phone";
        when(suspectedPatientService.isSuspectedPatient(healthyPhone)).thenReturn(false);

        float highTemperature = 38.0F;

        final HealthyStatusWrapper healthyStatus = healthyVerifierService.generateHealthyStatus(healthyPhone, highTemperature, noSymptoms);

        Assertions.assertEquals(HealthyStatus.UNHEALTHY.getStatus(), healthyStatus.getVal());
    }

    @Test
    public void should_be_unhealthy_when_it_has_symptoms() {
        float lowTemperature = 36.3F;
        String healthyPhone = "healthy_phone";
        when(suspectedPatientService.isSuspectedPatient(healthyPhone)).thenReturn(false);

        final Result hasSymptoms = Result.YES;

        final HealthyStatusWrapper healthyStatus = healthyVerifierService.generateHealthyStatus(healthyPhone, lowTemperature, hasSymptoms);

        Assertions.assertEquals(HealthyStatus.UNHEALTHY.getStatus(), healthyStatus.getVal());
    }

    @Test
    public void should_be_unhealthy_when_the_phone_is_in_suspected_list() {
        float lowTemperature = 36.3F;
        final Result noSymptoms = Result.NO;

        String unhealthyPhone = "unhealthy_phone";
        when(suspectedPatientService.isSuspectedPatient(Mockito.any(String.class))).thenReturn(true);

        final HealthyStatusWrapper healthyStatus = healthyVerifierService.generateHealthyStatus(unhealthyPhone, lowTemperature, noSymptoms);

        Assertions.assertEquals(HealthyStatus.UNHEALTHY.getStatus(), healthyStatus.getVal());
    }

    @Test
    public void should_be_healthy_when_it_has_no_symptoms_low_temperature_and_not_suspect() {
        float lowTemperature = 36.3F;
        final Result noSymptoms = Result.NO;
        String healthyPhone = "healthy_phone";
        when(suspectedPatientService.isSuspectedPatient(Mockito.any(String.class))).thenReturn(false);

        final HealthyStatusWrapper healthyStatus = healthyVerifierService.generateHealthyStatus(healthyPhone, lowTemperature, noSymptoms);

        Assertions.assertEquals(HealthyStatus.HEALTHY.getStatus(), healthyStatus.getVal());
    }
}