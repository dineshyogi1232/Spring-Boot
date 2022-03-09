package com.customercrudapplication.exceptionhandler;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(value = NullPointerException.class)
	public String nullPointerException(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message", " 500 - Null Pointer exception Occured");
		return "pagenotfound";
	}

	@ExceptionHandler(value = NoClassDefFoundError.class)
	public String NoClassDefFoundException(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message", " 500 !!! No ClassDef Found !!!");
		return "pagenotfound";
	}

	@ExceptionHandler(value = ClassNotFoundException.class)
	public String classNotException(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message", " 500 !!! Class Not Found !!!");
		return "pagenotfound";
	}

	@ExceptionHandler(value = NotFoundException.class)
	public String pageNotFoundException(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message", " 404  !!! Page not Found !!!");
		return "pagenotfound";
	}

	@ExceptionHandler(value = Exception.class)
	public String globalException(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message", " 500  !!! Page not Found !!!");
		return "pagenotfound";
	}

}