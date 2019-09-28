package com.woollen.order.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author weiyang
 * @since 2019-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RefundOrder extends Model<RefundOrder> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号
     */
    private String seq;

    /**
     * 第三方交易单号
     */
    private String outSeq;

    /**
     * 第三方交易单号
     */
    private String refundSeq;

    /**
     * 3:申请退款，4:退款审核中，5:退款完成，6:退款失败
     */
    private Integer status;

    /**
     * 退款金额，单位分
     */
    private Long refundFee;

    /**
     * 实际支付金额，单位分
     */
    private Long payFee;

    /**
     * 支付渠道
     */
    private Integer payChannel;

    /**
     * 退款完成时间
     */
    private Long refundTime;

    /**
     * 创建时间，即申请退款实际
     */
    private Long created;

    /**
     * 更新时间
     */
    private Long updated;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
