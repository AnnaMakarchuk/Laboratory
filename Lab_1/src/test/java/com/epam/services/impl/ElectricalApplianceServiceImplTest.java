package com.epam.services.impl;

import com.epam.factories.ElectricalApplianceFactory;
import com.epam.models.ElectricalAppliance;
import com.epam.repository.ElectricalApplianceRepository;
import com.epam.services.ElectricalApplianceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ElectricalApplianceServiceImplTest {
    private ElectricalApplianceService apllianceService;
    private List<ElectricalAppliance> applianceList;

    @Mock
    ElectricalApplianceRepository repository;

    @Before
    public void setUp() {
        apllianceService = new ElectricalApplianceServiceImpl(repository);
        ElectricalAppliance appliance1 = ElectricalApplianceFactory.createTechnique("LARGEHOMEAPPLIANCE")
                .createFactory("Fringe", "Zanussi", 200, 2010,
                        true, "storage");
        ElectricalAppliance appliance2 = ElectricalApplianceFactory.createTechnique("LARGEHOMEAPPLIANCE")
                .createFactory("Fringe", "Zanussi", 200, 2010,
                        true, "storage");
        ElectricalAppliance appliance3 = ElectricalApplianceFactory.createTechnique("MULTIMEDIA")
                .createFactory("TV", "LG", 340, 2009,
                        true, "TV");
        ElectricalAppliance appliance4 = ElectricalApplianceFactory.createTechnique("powertool")
                .createFactory("Router", "Asus", 10, 2012,
                        true, "router");
        applianceList = new ArrayList<>();
        applianceList.add(appliance1);
        applianceList.add(appliance2);
        applianceList.add(appliance3);
        applianceList.add(appliance4);
    }

    @Test
    public void shouldCreateListOrderByPower() {
        when(repository.findApplianceSortByPower()).thenReturn(applianceList);
        List<ElectricalAppliance> resultList = apllianceService.createApplianceSortByPower();
        assertThat(resultList, notNullValue());
        assertThat(resultList, hasSize(4));
    }

    @Test
    public void shouldFindTotalPower(){
        int actual = 750;
        when(repository.findTotalPower()).thenReturn(actual);
        int powerTotal = apllianceService.calculateTotalPowerConsumption();
        assertThat(powerTotal, equalTo(actual));
    }

    @Test
    public void shouldFindByParameters() {
        int power = 250;
        int year = 2005;
        when(repository.findApplianceByParameters(power, year)).thenReturn(applianceList.subList(2,3));
        List<ElectricalAppliance> resultList = apllianceService.createApplianceByParameters(power, year);
        assertThat(resultList, hasSize(1));
    }


}