package com.WorkersDataBase.service.companyFee;

import com.WorkersDataBase.data.companyFee.CompanyFeeRepository;
import com.WorkersDataBase.service.tools.MathTool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.WorkersDataBase.service.companyFee.ArrangeCompanyFeeRepository.*;
import static com.WorkersDataBase.service.companyFee.ArrangeMathTools.arrange_math_tool_returns_10;
import static org.junit.jupiter.api.Assertions.*;

class GetSumSkladkaRentowaTest {
    @Mock
    private CompanyFeeRepository companyFeeRepository;
    @Mock
    private MathTool tools;
    @InjectMocks
    private CompanyFeeGetService underTest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void getSumSkladkaRentowa_should_return_0() {
        //  Arrange
        arrange_company_repo_count_zero(companyFeeRepository);
        //  Assert
        assertEquals(0,underTest.getSumSkladkaEmerytalna());
    }
    @Test
    void getSumSkladkaRentowa_should_return_20() {
        //  Arrange
        arrange_company_repo_count_one(companyFeeRepository);
        arrange_math_tool_returns_10(tools);
        arrange_company_repo_getSumSkladkaRentowa_returns_10(companyFeeRepository);
        //  Assert
        assertEquals(20D,underTest.getSumSkladkaRentowa());
    }
}