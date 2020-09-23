package com.emc.metalnx.controller.api;

import java.util.List;

import org.irods.jargon.core.exception.JargonException;
import org.irods.jargon.datautils.shoppingcart.FileShoppingCart;
import org.irods.jargon.datautils.shoppingcart.ShoppingCartEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.WebApplicationContext;

import com.emc.metalnx.controller.BrowseController;
import com.emc.metalnx.core.domain.exceptions.DataGridException;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@RequestMapping(value = "/api/shoppingCart")
public class ShoppingCartApiController {

	public static final Logger logger = LoggerFactory.getLogger(ShoppingCartApiController.class);

	@Autowired
	private BrowseController browseController;

	@RequestMapping(value = "/getCart/", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public String showCart(final Model model) throws DataGridException, JargonException {
		logger.info("showCart()");
		FileShoppingCart fileShoppingCart = FileShoppingCart.instance();
		String serialized = fileShoppingCart.serializeShoppingCartContentsToStringOneItemPerLine();
		logger.info("cart content serialized :: " + serialized);
		return serialized;
	}

	@RequestMapping(value = "/updateCart/", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public String updateCart(final Model model, @RequestParam("paths[]") final String[] paths)
			throws DataGridException, JargonException {
		logger.info("initiating updateCart()");
		FileShoppingCart fileShoppingCart = FileShoppingCart.instance();

		for (String path : paths) {
			logger.info("Adding path to cart:: " + path.toString());
			fileShoppingCart.addAnItem(ShoppingCartEntry.instance(path.toString()));
		}

		List<String> fileNames = fileShoppingCart.getShoppingCartFileList();
		logger.info("Items in cart :: " + fileShoppingCart.hasItems());
		logger.info("Files in cart:: " + fileNames);

		return browseController.getSubDirectories(model, browseController.getCurrentPath());
	}
}
