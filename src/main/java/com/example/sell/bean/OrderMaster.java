package com.example.sell.bean;



//订单表
import com.example.sell.enums.OrderStatusEnum;
import com.example.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate //time自动更新
public class OrderMaster {
    @Id
    private String orderId;


    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal  orderAmount;

    private Integer orderStatus = OrderStatusEnum.NEW.getCode();//订单状态

    private Integer payStatus = PayStatusEnum.WAIT.getCode();//支付状态

    private Date createTime;

    private Date updateTime;


}
