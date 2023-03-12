package bg.uni.fmi.lab02.additional;

public class Tasks {

    List<Product> booksWithPriceGreaterThan100 = productsList.stream()
            .filter(product -> product.getCategory().equals("Books") && product.getPrice() > 100)
            .collect(Collectors.toList());

    List<Order> ordersWithBabyProducts = orders.stream()
            .filter(order -> order.getProducts().stream()
                    .anyMatch(product -> "Baby".equals(product.getCategory()) && product.getPrice() > 100))
            .collect(Collectors.toList());

    List<Product> products = ... // assume we have a list of products

    List<Product> toys = products.stream()
            .filter(p -> p.getCategory().equals("Toys"))
            .peek(p -> p.setPrice(p.getPrice().multiply(new BigDecimal("0.9"))))
            .collect(Collectors.toList());

    List<Product> productList = orders.stream()
            .filter(order -> order.getOrderDate().isAfter(LocalDate.of(2021, 2, 1))
                    && order.getOrderDate().isBefore(LocalDate.of(2021, 4, 1)))
            .filter(order -> order.getCustomer().getTier() == 2)
            .flatMap(order -> order.getOrderItems().stream())
            .map(OrderItem::getProduct)
            .collect(Collectors.toList());

}
