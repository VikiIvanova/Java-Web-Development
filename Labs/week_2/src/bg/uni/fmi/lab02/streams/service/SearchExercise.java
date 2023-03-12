package bg.uni.fmi.lab02.streams.service;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import bg.uni.fmi.lab02.streams.entity.Item;
import bg.uni.fmi.lab02.streams.vo.PaymentMethod;
import bg.uni.fmi.lab02.streams.vo.OrderStatus;
import bg.uni.fmi.lab02.streams.vo.OrderLineStatus;
import bg.uni.fmi.lab02.streams.Order;
import bg.uni.fmi.lab02.streams.OrderLine;
import bg.uni.fmi.lab02.streams.User;



public class SearchExercise {

    public List<Order> getActiveOrders(User user) {
        return user.getOrderList().stream()
                .filter(Order::isActive)
                .collect(Collectors.toList());
    }

    public List<Order> getActiveOrdersByIteration(User user) {
        List<Order> activeOrdersList = new ArrayList<>();
        for(Order current : user.getOrderList()) {
            if (current.getOrderStatus() == OrderStatus.ACTIVE) {
                activeOrdersList.add(current);
            }
        }
        return activeOrdersList;
    }

    public Order getOrderById(List<Order> orders, long orderId) {
        return orders.stream()
                .filter(order->order.getId() == orderId)
                .findFirst()
                .orElse(null);

    }

    public Order getOrderByIdIteration(List<Order> orders, long orderId) {
        for(Order order : orders) {
            if (order.getId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getOrdersThatHaveItemDescription(User user, String description) {
       return user.getOrderList().stream()
               .filter(order->order.getOrderLineList().contains(new OrderLine(new Item(description, new BigDecimal(0)),
                       OrderLineStatus.IN_STOCK, false, 1)))
                       .collect(Collectors.toList());
    }

    public boolean hasActiveOrders(User user) {
       for(Order order : user.getOrderList()) {
           if(order.getOrderStatus().equals(OrderStatus.ACTIVE)) {
               return true;
           }
       }
       return false;
    }

    public boolean canBeReturned(Order order) {
        return order.getOrderLineList()
                .stream()
                .noneMatch(OrderLine::isSpecialOffer);
    }

    public Optional<Order> getMaxPriceOrder(User user) {
        return  user.getOrderList()
                .stream()
                .max((order1, order2) -> order2.getTotalPrice().compareTo(order1.getTotalPrice()));
    }

    public static void main(String[] args) {

        SearchExercise searchExercise = new SearchExercise();
        List<Order> orderList = new ArrayList<>();
        User user = new User();

        OrderLine orderLineFirst = new OrderLine(new Item("banana", new BigDecimal(3)), OrderLineStatus.IN_STOCK,
                true, 10);

        Order first = new Order(2, List.of(orderLineFirst), LocalDate.now(), new BigDecimal(4), PaymentMethod.CASH_ON_DELIVERY,
                LocalDate.now().plusDays(2), user, "Nanana");

        orderList.add(first);
        user.addOrder(first);

        OrderLine orderLineSecond = new OrderLine(new Item("milk", new BigDecimal(5)), OrderLineStatus.OUT_OF_STOCK,
                false, 12);

        Order second = new Order(3, List.of(orderLineSecond), LocalDate.now(), new BigDecimal(9), PaymentMethod.CARD,
                LocalDate.now().plusDays(1), user, "Bababa");

        orderList.add(second);
        user.addOrder(second);

        first.setOrderStatus(OrderStatus.ACTIVE);

        System.out.println(searchExercise.getActiveOrders(user));
        System.out.println(searchExercise.getActiveOrdersByIteration(user));
        System.out.println(searchExercise.getOrderById(orderList, 3));
        System.out.println(searchExercise.getOrderByIdIteration(orderList, 22));
        System.out.println(searchExercise.getOrdersThatHaveItemDescription(user, "milk"));
        System.out.println(searchExercise.hasActiveOrders(user));
        System.out.println(searchExercise.canBeReturned(first));
        System.out.println(searchExercise.canBeReturned(second));
        System.out.println(searchExercise.getMaxPriceOrder(user));
    }

}

