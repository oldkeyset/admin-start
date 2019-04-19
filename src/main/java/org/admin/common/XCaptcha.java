package org.admin.common;

import java.awt.Color;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bingoohuang.patchca.background.SingleColorBackgroundFactory;
import com.github.bingoohuang.patchca.color.SingleColorFactory;
import com.github.bingoohuang.patchca.filter.predefined.WobbleRippleFilterFactory;
import com.github.bingoohuang.patchca.font.RandomFontFactory;
import com.github.bingoohuang.patchca.service.AbstractCaptchaService;
import com.github.bingoohuang.patchca.service.Captcha;
import com.github.bingoohuang.patchca.text.renderer.BestFitTextRenderer;
import com.github.bingoohuang.patchca.text.renderer.TextRenderer;
import com.github.bingoohuang.patchca.word.AdaptiveRandomWordFactory;
import com.github.bingoohuang.patchca.word.RandomWordFactory;


public class XCaptcha extends AbstractCaptchaService{

	private static Logger logger = LoggerFactory.getLogger(XCaptcha.class);
	
	private static XCaptcha instance = null;
	
	private XCaptcha() {

		this.setBackgroundFactory(new SingleColorBackgroundFactory());
		//this.setColorFactory(new RandomColorFactory());
		this.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
		//this.setFilterFactory(new CurvesRippleFilterFactory(this.getColorFactory()));
		this.setFilterFactory(new WobbleRippleFilterFactory());
		this.setWidth(90);
		this.setHeight(40);
		
		RandomWordFactory wordFactory = new AdaptiveRandomWordFactory();
        wordFactory.setMaxLength(4);  
        wordFactory.setMinLength(4);
        this.setWordFactory(wordFactory);
        
        RandomFontFactory fontFactory = new RandomFontFactory();
		fontFactory.setMaxSize(36);
		fontFactory.setMinSize(24);
		this.setFontFactory(fontFactory);
		
		TextRenderer textRenderer = new BestFitTextRenderer();
        textRenderer.setBottomMargin(4);
        textRenderer.setTopMargin(4);
        this.setTextRenderer(textRenderer);
	}
	
	public static XCaptcha getInstance(){
		if(instance == null){
			instance = new XCaptcha();
		}
		return instance;
	}


	public String getChallangeAndWriteImage(OutputStream os) {
		try {
			Captcha captcha = this.getCaptcha();
			ImageIO.write(captcha.getImage(), "png", os);
			return captcha.getChallenge();
		}catch(Exception e){
			logger.error("XPatchca.getChallangeAndWriteImage.Exception:", e);
		}
		return null;
	}
	
}
