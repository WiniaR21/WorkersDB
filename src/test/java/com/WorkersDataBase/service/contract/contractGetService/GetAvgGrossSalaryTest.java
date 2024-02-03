package com.WorkersDataBase.service.contract.contractGetService;


import com.WorkersDataBase.data.contract.ContractRepository;
import com.WorkersDataBase.service.contract.ContractGetService;
import com.WorkersDataBase.service.tools.MathTool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static com.WorkersDataBase.service.companyFee.ArrangeMathTools.arrange_math_tool_returns_10;
import static com.WorkersDataBase.service.contract.contractGetService.ArrangeContractRepository.*;
import static org.junit.jupiter.api.Assertions.*;

class GetAvgGrossSalaryTest {

    @Mock
    private ContractRepository contractRepository;
    @Mock
    private MathTool tools;
    @InjectMocks
    private ContractGetService underTest;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void getAvgGrossSalary_should_return_0() {
        //  Arrange
        arrange_contract_repo_count_zero(contractRepository);
        //  Assert
        assertEquals(0, underTest.getAvgGrossSalary());
    }
    @Test
    void getAvgGrossSalary_should_return_0_should_return_20() {
        //  Arrange
        arrange_contract_repo_count_one(contractRepository);
        arrange_math_tool_returns_10(tools);
        arrange_contract_repo_getAvgGrossSalary_returns_10(contractRepository);
        //  Assert
        assertEquals(20,underTest.getAvgGrossSalary());
    }
}