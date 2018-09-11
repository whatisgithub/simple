package cn.cpic.insurance.web.controller.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @NotNull 限制必须不为null
 * @NotEmpty 验证注解的元素值不为 null 且不为空（字符串长度不为0、集合大小不为0）
 * @NotBlank 验证注解的元素值不为空（不为null、去除首位空格后长度为0），不同于@NotEmpty，@NotBlank只应用于字符串且在比较时会去除字符串的空格
 * @Pattern(value) 限制必须符合指定的正则表达式
 * @Size(max,min) 限制字符长度必须在 min 到 max 之间（也可以用在集合上）
 * @Email 验证注解的元素值是Email，也可以通过正则表达式和flag指定自定义的email格式
 * @Max(value) 限制必须为一个不大于指定值的数字
 * @Min(value) 限制必须为一个不小于指定值的数字
 * @DecimalMax(value) 限制必须为一个不大于指定值的数字
 * @DecimalMin(value) 限制必须为一个不小于指定值的数字
 * @Null 限制只能为null（很少用）
 * @AssertFalse 限制必须为false （很少用）
 * @AssertTrue 限制必须为true （很少用）
 * @Past 限制必须是一个过去的日期
 * @Future 限制必须是一个将来的日期
 * @Digits(integer,fraction) 限制必须为一个小数，且整数部分的位数不能超过 integer，小数部分的位数不能超过 fraction （很少用）
 */
@Getter
@Setter
@ToString
public class ValidateVo {

    @NotBlank(message = "name 不允许为空")
    @Length(min = 2, max = 10, message = "name 长度必须在 {min} - {max} 之间")
    private String name;
    private String mobile;
}
