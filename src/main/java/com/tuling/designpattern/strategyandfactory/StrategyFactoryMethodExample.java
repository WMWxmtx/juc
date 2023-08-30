package com.tuling.designpattern.strategyandfactory;
//策略模式与工厂模式混合使用
// 付款策略模式接口 侧重点在于接口中的方法各个类实现的不一样
// 付款策略工厂 返回的是 PaymentStrategy接口 侧重点在于，应该返回哪个具体的实现类

/**
 相似之处：

 解耦和灵活性： 两者都有助于解耦代码，提高系统的灵活性和可维护性。两者都是定义出接口，由不同的实现类去实现接口，从而实现不同的功能。

 不同之处：

 表现：
  工厂模式：主要是用于创建对象，它的主要目标是封装对象的实例化逻辑。
  策略模式：主要是用于决定由那个实现类来执行指定的方法

 用途：
 工厂模式： 主要用于创建对象的过程。它可以隐藏具体类的实例化过程，客户端只需与工厂接口交互，从而降低耦合。
 策略模式： 主要用于定义一族算法或行为，将其封装成独立的策略类，并使这些策略类可以相互替换。它用于实现不同的算法或逻辑的变体，而不涉及对象的创建。

 关注点：
 工厂模式： 关注于创建对象，它的主要目标是封装对象的实例化逻辑。
 策略模式： 关注于定义不同的策略或算法，它的主要目标是封装可互换的行为。

 类别：
 工厂模式： 可以根据创建方式分为简单工厂、工厂方法和抽象工厂。
 策略模式： 通常涉及上下文、策略接口和具体策略实现。

 作用域：
 工厂模式： 通常涉及对象的创建，影响范围更广。
 策略模式： 主要涉及算法或行为的封装，影响范围相对较窄。

 使用情景：
 工厂模式： 当需要创建不同类型的对象，但客户端不需要关心具体的实例化逻辑时，可以使用工厂模式。
 策略模式： 当需要在运行时根据不同情况选择不同的算法或行为时，可以使用策略模式。
 */


// 付款策略接口 侧重点在于接口中的方法各个类实现的不一样
interface PaymentStrategy {
    void pay(double amount);
}

// 具体付款策略
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using credit card: " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using PayPal account: " + email);
    }
}

// 付款策略工厂
// 返回的是 PaymentStrategy接口
//侧重点在于，应该返回哪个具体的实现类
interface PaymentStrategyFactory {
    PaymentStrategy createPaymentStrategy();
}

class CreditCardPaymentFactory implements PaymentStrategyFactory {
    private String cardNumber;

    public CreditCardPaymentFactory(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public PaymentStrategy createPaymentStrategy() {
        return new CreditCardPayment(cardNumber);
    }
}

class PayPalPaymentFactory implements PaymentStrategyFactory {
    private String email;

    public PayPalPaymentFactory(String email) {
        this.email = email;
    }

    @Override
    public PaymentStrategy createPaymentStrategy() {
        return new PayPalPayment(email);
    }
}

// 订单类
class Order {
    private double totalAmount;
    private PaymentStrategy paymentStrategy;

    public Order(double totalAmount, PaymentStrategyFactory paymentStrategyFactory) {
        this.totalAmount = totalAmount;
        this.paymentStrategy = paymentStrategyFactory.createPaymentStrategy();
    }

    public void processOrder() {
        paymentStrategy.pay(totalAmount);
    }
}

// 客户端代码
public class StrategyFactoryMethodExample {
    public static void main(String[] args) {
        double orderAmount = 100.0;

        PaymentStrategyFactory creditCardPaymentFactory = new CreditCardPaymentFactory("123456789");
        Order orderWithCreditCard = new Order(orderAmount, creditCardPaymentFactory);
        orderWithCreditCard.processOrder();

        PaymentStrategyFactory paypalPaymentFactory = new PayPalPaymentFactory("user@example.com");
        Order orderWithPayPal = new Order(orderAmount, paypalPaymentFactory);
        orderWithPayPal.processOrder();
    }
}
