package com.esaa.corp.stock.producer.sales.models.mappers;

import com.esaa.corp.stock.producer._commons.models.database.Sale;
import com.esaa.corp.stock.producer._commons.models.database.SaleDetail;
import com.esaa.corp.stock.producer.sales.models.dto.SaleResponseDto;
import com.esaa.corp.stock.producer.sales.models.dto.SaleSingeItemResponseDto;
import com.esaa.corp.stock.producer.sales.models.dto.SaleSingleItemRequestDto;

import java.util.ArrayList;
import java.util.List;

public class CreateSaleMapper {

    public SaleDetail singleItemRequestModelToDbModel(final SaleSingleItemRequestDto requestModel) {
        final SaleDetail saleDetail = new SaleDetail();
        saleDetail.setItemId(requestModel.getItemId());
        saleDetail.setSaleQuantity(requestModel.getQuantity());
        return saleDetail;
    }

    public SaleSingeItemResponseDto saleDbModelToSingleItemResponse(final SaleDetail item) {
        final SaleSingeItemResponseDto response = new SaleSingeItemResponseDto();
        response.setItemId(item.getItemId());
        response.setItemName(item.getItemName());
        response.setItemCode(item.getItemCode());
        response.setSaleQuantity(item.getSaleQuantity());
        response.setTotalAmount(item.getDetailTotal());
        response.setPricePerUnit(item.getPricePerUnit());
        return response;
    }

    public SaleResponseDto saleDbModelToResponseModel(Sale sale) {

        final SaleResponseDto response = new SaleResponseDto();
        response.setSaleId(sale.getId());
        response.setTotal(sale.getTotal());

        final List<SaleSingeItemResponseDto> items =
                sale.getItems()
                        .stream()
                        .map(this::saleDbModelToSingleItemResponse)
                        .toList();

        response.setItems(items);

        return response;
    }
}
