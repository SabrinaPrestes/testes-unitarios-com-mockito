package orderTest;

import org.example.model.Order;
import org.example.repository.OrderRepository;
import org.example.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    private OrderService orderService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderService(orderRepository);
    }

    @Test
    public void testGetOrderItemName_OrderExists_ReturnItemName() {
        Order fakeOrder = new Order(1L, "Tablet", 1);
        when(orderRepository.findOrderById(1L)).thenReturn(fakeOrder);

        String itemName = orderService.getOrderItemName(1L);
        assertEquals("Tablet", itemName);
        verify(orderRepository).findOrderById(1L);
    }

    @Test
    public void testGetOrderItemName_OrderNotFound_ReturnsMessage() {
        when(orderRepository.findOrderById(999L)).thenReturn(null);
        String result = orderService.getOrderItemName(999L);
        assertEquals("Order not found", result);
        verify(orderRepository).findOrderById(999l);
    }

}
