package ai.nova.nex.server.controller.open;

import cloud.tianai.captcha.application.ImageCaptchaApplication;
import cloud.tianai.captcha.application.vo.CaptchaResponse;
import cloud.tianai.captcha.application.vo.ImageCaptchaVO;
import cloud.tianai.captcha.common.constant.CaptchaTypeConstant;
import cloud.tianai.captcha.common.response.ApiResponse;
import cloud.tianai.captcha.spring.plugins.secondary.SecondaryVerificationApplication;
import cloud.tianai.captcha.validator.common.model.dto.ImageCaptchaTrack;
import cn.dev33.satoken.annotation.SaIgnore;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 小正
 * @date 2025年07月29日 18:49
 * @Description 请填写此类描述
 */
@RequestMapping("/open/captcha")
@RestController
@Slf4j
@SaIgnore
public class CaptchaController {

    @lombok.Data
    public static class Data {
        private String  id;
        private ImageCaptchaTrack data;
    }

    private static final Map<Integer, String> CAPTCHA_TYPES = Map.of(
            0, CaptchaTypeConstant.SLIDER,
            1, CaptchaTypeConstant.CONCAT,
            2, CaptchaTypeConstant.ROTATE,
            3, CaptchaTypeConstant.WORD_IMAGE_CLICK
    );


    @Resource
    private ImageCaptchaApplication imageCaptchaApplication;


    /*
    * 生成通用验证码 TIANAI-CAPTCHA
    * type: RANDOM 随机生成验证码
    * */
    @RequestMapping("/generate_generic")
    @ResponseBody
    public CaptchaResponse<ImageCaptchaVO> genCaptcha(@RequestParam(value = "type", required = false)String type) {
        type = StringUtils.isBlank(type) ? CaptchaTypeConstant.SLIDER : type;
        if ("RANDOM".equals(type)) {
            int randomIndex = ThreadLocalRandom.current().nextInt(CAPTCHA_TYPES.size());
            type = CAPTCHA_TYPES.get(randomIndex);
        }
        return imageCaptchaApplication.generateCaptcha(type);
    }

    /*
    * 验证码验证
    * */
    @PostMapping("/check")
    @ResponseBody
    public ApiResponse<?> checkCaptcha(@RequestBody CaptchaController.Data data) {
        ApiResponse<?> response = imageCaptchaApplication.matching(data.getId(), data.getData());
        if (response.isSuccess()) {
            return ApiResponse.ofSuccess(Collections.singletonMap("id", data.getId()));
        }
        return response;
    }

    @GetMapping("/check2")
    @ResponseBody
    public boolean check2Captcha(@RequestParam("id") String id) {
        // 如果开启了二次验证
        if (imageCaptchaApplication instanceof SecondaryVerificationApplication) {
            return ((SecondaryVerificationApplication) imageCaptchaApplication).secondaryVerification(id);
        }
        return false;
    }
}
