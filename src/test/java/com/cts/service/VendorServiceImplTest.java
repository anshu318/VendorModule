package com.cts.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.cts.Exception.NoVendorFoundException;
import com.cts.Repository.VendorRepo;
import com.cts.Service.VendorService;
import com.cts.model.Vendor;

@SpringBootTest
class VendorServiceImplTest {

	@Autowired
	VendorService vendorService;

	@MockBean
	VendorRepo vendorRepository;

	@Test
	void testFindByVendorId() {
		Vendor vendor = new Vendor(1, "Amazon", 30.5, 5.0);
		long vendorId = 1;
		when(vendorRepository.findById(vendorId)).thenReturn(vendor);
		assertEquals(vendorService.findByVendorId(vendorId).getVendorId(), vendor.getVendorId());
	}
 /*
	@Test
	void testFindByVendorIdVendorNotFoundException() {
		long vendorId = 101;
		when(vendorRepository.findById(vendorId)).thenReturn(null);
		Exception exception = assertThrows(NoVendorFoundException.class, () -> vendorService.findByVendorId(vendorId));
		assertEquals("Vendore With id [" + vendorId + "] not found", exception.getMessage());
	}*/
}