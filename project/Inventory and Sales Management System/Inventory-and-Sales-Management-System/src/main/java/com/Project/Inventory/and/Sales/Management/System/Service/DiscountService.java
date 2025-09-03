package com.Project.Inventory.and.Sales.Management.System.Service;

import com.Project.Inventory.and.Sales.Management.System.Entity.Discount;
import com.Project.Inventory.and.Sales.Management.System.Repository.DiscountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DiscountService {

    private final DiscountRepository discountRepository;

    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    // Retrieve all discounts (admin)
    public List<Discount> getAllDiscounts() {
        return discountRepository.getAll();
    }

    // Retrieve active discounts (public)
    public List<Discount> getActiveDiscounts() {
        return discountRepository.getActiveDiscounts();
    }

    // Get discount by ID
    public Discount getDiscountById(int id) {
        return discountRepository.getById(id);
    }

    // Create new discount (admin)
    public void createDiscount(Discount discount) {
        validateDiscount(discount);
        discountRepository.save(discount);
    }

    // Update existing discount (admin)
    public void updateDiscount(Discount discount) {
        validateDiscount(discount);
        discountRepository.update(discount);
    }

    // Delete discount by ID (admin)
    public void deleteDiscount(int id) {
        discountRepository.delete(id);
    }

    // Validation method to check discount data
    private void validateDiscount(Discount discount) {
        if (discount.getPercentage() == null || discount.getPercentage() <= 0 || discount.getPercentage() > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 1 and 100.");
        }
        if (discount.getStartDate() == null || discount.getEndDate() == null) {
            throw new IllegalArgumentException("Start date and end date cannot be null.");
        }
        if (discount.getStartDate().isAfter(discount.getEndDate())) {
            throw new IllegalArgumentException("Start date cannot be after end date.");
        }
    }
}
