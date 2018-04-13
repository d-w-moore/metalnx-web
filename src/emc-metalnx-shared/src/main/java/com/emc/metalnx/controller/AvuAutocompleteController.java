package com.emc.metalnx.controller;

import javax.servlet.http.HttpServletResponse;

import org.irods.jargon.core.exception.JargonException;
import org.irods.jargon.datautils.avuautocomplete.AvuAutocompleteService.AvuTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.emc.metalnx.controller.utils.LoggedUserUtils;
import com.emc.metalnx.services.interfaces.AvuAutoCompleteDelegateService;
import com.emc.metalnx.services.interfaces.IRODSServices;
import com.emc.metalnx.services.interfaces.PermissionsService;
import com.emc.metalnx.services.interfaces.UserService;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@RequestMapping(value = "/avuAutoComplete", produces = "application/json")
public class AvuAutocompleteController {

	@Autowired
	UserService userService;

	@Autowired
	PermissionsService permissionsService;

	@Autowired
	LoggedUserUtils loggedUserUtils;

	@Autowired
	IRODSServices irodsService;

	@Autowired
	AvuAutoCompleteDelegateService autoCompleteDelegateService;

	private static final Logger logger = LoggerFactory.getLogger(AvuAutocompleteController.class);

	@RequestMapping(value = "/getMetadataAttrs", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getMetadataAttr(final HttpServletResponse response) throws JargonException {

		logger.info("controller: /getMetadataAttrs ");
		
		//TODO: get parameters from controller call
		String avuRes = autoCompleteDelegateService.getMetadataAttrs("%", 0, AvuTypeEnum.COLLECTION);
		logger.info("AvuREs: {}", avuRes);
		return avuRes;
	}

	public IRODSServices getIrodsService() {
		return irodsService;
	}

	public void setIrodsService(IRODSServices irodsService) {
		this.irodsService = irodsService;
	}
}
