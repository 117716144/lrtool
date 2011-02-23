package com.base.core.action.keywords;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.core.BaseAction;

import flex.messaging.io.ArrayCollection;
import flex.messaging.io.MessageDeserializer;
import flex.messaging.io.SerializationContext;
import flex.messaging.io.amf.ASObject;
import flex.messaging.io.amf.ActionContext;
import flex.messaging.io.amf.ActionMessage;
import flex.messaging.io.amf.Amf0Input;
import flex.messaging.io.amf.Amf0Output;
import flex.messaging.io.amf.AmfMessageDeserializer;
import flex.messaging.io.amf.MessageBody;
import flex.messaging.io.amf.MessageHeader;
import flex.messaging.io.amf.client.AMFConnection;

@SuppressWarnings("serial")
public class AmfResolveAction extends BaseAction {

	private ActionMessage in(InputStream is) throws IOException,
			ClassNotFoundException {
		ActionMessage inMs = new ActionMessage();
		Amf0Input amfIn = new Amf0Input(SerializationContext
				.getSerializationContext());
		amfIn.setInputStream(is);
		int version = amfIn.readUnsignedShort();
		inMs.setVersion(version);

		int headerCount = amfIn.readUnsignedShort();
		for (int i = 0; i < headerCount; ++i) {
			MessageHeader header = new MessageHeader();
			inMs.addHeader(header);
			header.setName(amfIn.readUTF());
			header.setMustUnderstand(amfIn.readBoolean());
			amfIn.readInt();
			amfIn.reset();
			header.setData(amfIn.readObject());
		}

		int bodyCount = amfIn.readUnsignedShort();
		for (int i = 0; i < bodyCount; ++i) {
			MessageBody body = new MessageBody();
			inMs.addBody(body);
			body.setTargetURI(amfIn.readUTF());
			body.setResponseURI(amfIn.readUTF());
			amfIn.readInt();
			amfIn.reset();
			body.setData(amfIn.readObject());
		}

		amfIn.close();
		amfIn = null;

		return inMs;
	}

	/**
	 * java --> flash
	 * 
	 * @param o
	 * @throws IOException
	 * @throws Exception
	 */
	private void out(ActionMessage outMs, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();

		Amf0Output amfOut = new Amf0Output(SerializationContext
				.getSerializationContext());
		int version = outMs.getVersion();
		amfOut.setAvmPlus(version > 0);
		amfOut.setOutputStream(outBuffer);
		amfOut.writeShort(version);

		int headerCount = outMs.getHeaderCount();
		amfOut.writeShort(headerCount);
		for (int i = 0; i < headerCount; ++i) {
			MessageHeader header = outMs.getHeader(i);
			amfOut.writeUTF(header.getName());
			amfOut.writeBoolean(header.getMustUnderstand());
			amfOut.writeInt(-1);
			amfOut.reset();
			amfOut.writeObject(header.getData());
		}

		int bodyCount = outMs.getBodyCount();
		amfOut.writeShort(bodyCount);
		for (int i = 0; i < bodyCount; ++i) {
			MessageBody body = outMs.getBody(i);
			if (body.getTargetURI() == null)
				amfOut.writeUTF("null");
			else
				amfOut.writeUTF(body.getTargetURI());
			if (body.getResponseURI() == null)
				amfOut.writeUTF("null");
			else
				amfOut.writeUTF(body.getResponseURI());
			amfOut.writeInt(-1);
			amfOut.reset();
			amfOut.writeObject(body.getData());
		}

		response.setContentType(request.getContentType());
		response.setContentLength(outBuffer.size());
		outBuffer.writeTo(response.getOutputStream());
		response.flushBuffer();
		amfOut.flush();
		amfOut.close();
		amfOut = null;
	}

	// @Override
	// protected void service(HttpServletRequest req, HttpServletResponse resp)
	// throws ServletException, IOException {
	// Action4J action = new Action4J();
	// IContext icontext = new InnerContextImpl();
	// IArguments args = ArgumentsFactory.getArguments();
	//
	// action.setContext(icontext);
	// action.setRequest(req);
	// action.setResponse(resp);
	// action.setServletConfig(getServletConfig());
	// action.setServletContext(getServletContext());
	//
	// ActionMessage outMs = new ActionMessage();
	// ActionMessage inMs = null;
	// try {
	// inMs = in(req.getInputStream());
	// outMs.setVersion(inMs.getVersion());
	//
	// for (int i = 0; i < inMs.getBodyCount(); i++) {
	//
	// MessageBody body = inMs.getBody(i);
	// String method = body.getReplyMethod().split("\\.")[1];
	// Object[] o = (Object[]) body.getData();
	//
	// Object[] arr = (Object[]) o;
	// for (int j = 0; j < arr.length; j++) {
	// args.add("index" + (j + 1), arr[j]);
	// }
	//
	// action.execute("/" + method, args);
	// Object result = action.getContext().get("result");
	//
	// MessageBody responseBody = new MessageBody();
	// responseBody.setData(result);
	// responseBody.setTargetURI(body.getResponseURI() + "/onResult");
	// outMs.addBody(responseBody);
	//
	// args.clear();
	// }
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// MessageBody responseBody = new MessageBody();
	// responseBody.setData(new Object[] { 100 });
	// responseBody.setTargetURI(inMs.getBody(0).getResponseURI()
	// + "/onResult");
	// outMs.addBody(responseBody);
	// } finally {
	// args.clear();
	// out(outMs, req, resp);
	// }
	// }

	public void test(HttpServletRequest request) {
		String url = "http://index.baidu.com/gateway.php";
		// Generates the connection to the amf gateway.
		AMFConnection amfConnection = new AMFConnection();
		AMFConnection.registerAlias("", new AmfResolveAction().getClass()
				.getName());
		try {
			// Do the connection.
			amfConnection.connect(url);
			amfConnection.addHttpRequestHeader("Content-type",
					"application/x-amf");
			amfConnection.addHttpRequestHeader("Referer",
					"http://index.baidu.com/fla/TrendAnalyser.swf");
            
			ActionMessage msg = new ActionMessage();
			ASObject ao = new ASObject();
			ao.put("Target","/1/onResult");
			msg.getBodies().add(ao);
			//this.in(request.getInputStream());
			ArrayCollection cont = new ArrayCollection();
			ASObject aoj = new ASObject();
			aoj.put("key", "保险");
			aoj.put("area", "0");
			aoj.put("areaName", "");
			aoj.put("period", "2011-01-24|2011-02-22");
			cont.set(0, aoj);
			msg.getBodies().add(cont);
			msg = (ActionMessage) amfConnection.call("DataAccessor.getIndexes",
					msg);
			msg.getBodies();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void invokeBlazeDS(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ActionContext context = new ActionContext();
		// Create an empty ActionMessage object to hold our response
		ActionMessage actionMessage = new ActionMessage();
		actionMessage.addBody(new MessageBody());
		context.setResponseMessage(actionMessage);
		SerializationContext sc = SerializationContext
				.getSerializationContext();
		sc.setDeserializerClass(AmfMessageDeserializer.class);
		// Deserialize the input stream into an "ActionMessage" object.
		MessageDeserializer deserializer = sc.newMessageDeserializer();
		// Set up the deserialization context
		InputStream in = request.getInputStream();
		deserializer.initialize(sc, in, null);
		// record the length of the input stream for performance metrics
		context.setDeserializedBytes(request.getContentLength());

		try {
			ActionMessage m = new ActionMessage();
			context.setRequestMessage(m);
			deserializer.readMessage(m, context);

		} catch (Throwable t) {
			// just ignore for test
			t.printStackTrace();
		} finally {
			// Use the same ActionMessage version for the response
			ActionMessage respMsg = context.getResponseMessage();
			respMsg.setVersion(context.getVersion());
		}

		MessageBody inMessage = context.getRequestMessageBody();
		MessageBody outMessage = context.getResponseMessageBody();
		
	}
	


}
