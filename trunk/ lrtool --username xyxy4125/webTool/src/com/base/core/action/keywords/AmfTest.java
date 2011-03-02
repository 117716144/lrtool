package com.base.core.action.keywords;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import flex.messaging.io.MessageDeserializer;
import flex.messaging.io.MessageIOConstants;
import flex.messaging.io.SerializationContext;
import flex.messaging.io.amf.ASObject;
import flex.messaging.io.amf.ActionContext;
import flex.messaging.io.amf.ActionMessage;
import flex.messaging.io.amf.AmfMessageDeserializer;
import flex.messaging.io.amf.AmfMessageSerializer;
import flex.messaging.io.amf.MessageBody;

public class AmfTest {

	public static void test(String[] args) throws ClassNotFoundException, IOException {
		byte[] bb = {0x00, 0x00, 0x00, 0x01, 0x00, 0x12, 0x41, 0x70, 0x70, 0x65, 0x6E, 0x64, 0x54, 0x6F, 0x47, 0x61, 0x74, 0x65, 0x77, 0x61, 0x79, 0x55, 0x72, 0x6C, 0x00, 0x00, 0x00, 0x00, 0x28, 0x11, 0x06, 0x4B, 0x3F, 0x50, 0x48, 0x50, 0x53, 0x45, 0x53, 0x53, 0x49, 0x44, 0x3D, 0x63, 0x66, 0x35, 0x6B, 0x37, 0x30, 0x74, 0x32, 0x6F, 0x63, 0x66, 0x72, 0x64, 0x63, 0x6E, 0x63, 0x38, 0x32, 0x6C, 0x65, 0x6B, 0x38, 0x67, 0x38, 0x6E, 0x36, 0x00, 0x01, 0x00, 0x0C, 0x2F, 0x31, 0x39, 0x2F, 0x6F, 0x6E, 0x52, 0x65, 0x73, 0x75, 0x6C, 0x74, 0x00, 0x04, 0x6E, 0x75, 0x6C, 0x6C, 0x00, 0x00, 0x0D, 0xFFFFFFF7, 0x11, 0x0A, 0x0B, 0x01, 0x0D, 0x73, 0x74, 0x61, 0x74, 0x75, 0x73, 0x04, 0x01, 0x0F, 0x65, 0x72, 0x72, 0x63, 0x6F, 0x64, 0x65, 0x04, 0x00, 0x0B, 0x66, 0x6C, 0x69, 0x73, 0x74, 0x09, 0x25, 0x01, 0x0A, 0x0B, 0x01, 0x05, 0x69, 0x64, 0x06, 0x0B, 0x37, 0x32, 0x31, 0x31, 0x32, 0x07, 0x75, 0x69, 0x64, 0x06, 0x13, 0x32, 0x30, 0x30, 0x37, 0x37, 0x38, 0x35, 0x36, 0x31, 0x07, 0x66, 0x69, 0x64, 0x06, 0x13, 0x32, 0x34, 0x36, 0x37, 0x31, 0x30, 0x36, 0x35, 0x37, 0x0B, 0x66, 0x6E, 0x61, 0x6D, 0x65, 0x06, 0x21, 0xFFFFFFE6, 0xFFFFFF9D, 0xFFFFFF8E, 0xFFFFFFE7, 0xFFFFFF88, 0xFFFFFFBD, 0xFFFFFFEF, 0xFFFFFFBC, 0xFFFFFFB3, 0xFFFFFFC2, 0xFFFFFFB7, 0xFFFFFFEF, 0xFFFFFFBD, 0xFFFFFF8F, 0x6E, 0x65, 0x0D, 0x66, 0x6C, 0x65, 0x76, 0x65, 0x6C, 0x06, 0x05, 0x32, 0x35, 0x0B, 0x66, 0x61, 0x74, 0x74, 0x72, 0x0A, 0x0B, 0x01, 0x0A, 0x06, 0x10, 0x09, 0x6E, 0x61, 0x6D, 0x65, 0x06, 0x14, 0x0B, 0x65, 0x6E, 0x61, 0x6D, 0x65, 0x06, 0x25, 0x6C, 0x69, 0x73, 0x68, 0x75, 0x61, 0x6E, 0x67, 0xFFFFFFEF, 0xFFFFFFBC, 0xFFFFFFB3, 0xFFFFFFC2, 0xFFFFFFB7, 0xFFFFFFEF, 0xFFFFFFBD, 0xFFFFFF8F, 0x6E, 0x65, 0x0D, 0x69, 0x6D, 0x67, 0x75, 0x72, 0x6C, 0x06, 0xFFFFFF81, 0x17, 0x68, 0x74, 0x74, 0x70, 0x3A, 0x2F, 0x2F, 0x68, 0x64, 0x6E, 0x2E, 0x78, 0x6E, 0x69, 0x6D, 0x67, 0x2E, 0x63, 0x6E, 0x2F, 0x70, 0x68, 0x6F, 0x74, 0x6F, 0x73, 0x2F, 0x68, 0x64, 0x6E, 0x32, 0x32, 0x31, 0x2F, 0x32, 0x30, 0x31, 0x30, 0x30, 0x36, 0x31, 0x34, 0x2F, 0x32, 0x33, 0x34, 0x35, 0x2F, 0x74, 0x69, 0x6E, 0x79, 0x5F, 0x30, 0x54, 0x6C, 0x72, 0x5F, 0x31, 0x30, 0x31, 0x39, 0x30, 0x31, 0x6E, 0x30, 0x31, 0x39, 0x31, 0x31, 0x37, 0x2E, 0x6A, 0x70, 0x67, 0x0B, 0x61, 0x76, 0x61, 0x74, 0x61, 0x06, 0x37, 0x31, 0x30, 0x3A, 0x31, 0x30, 0x3A, 0x31, 0x31, 0x3A, 0x31, 0x30, 0x3A, 0x35, 0x3A, 0x31, 0x3A, 0x31, 0x31, 0x3A, 0x35, 0x3A, 0x35, 0x3A, 0x35, 0x3A, 0x31, 0x31, 0x0B, 0x6C, 0x65, 0x76, 0x65, 0x6C, 0x06, 0x18, 0x06, 0x06, 0x09, 0x34, 0x30, 0x37, 0x39, 0x09, 0x73, 0x74, 0x61, 0x72, 0x04, 0x01, 0x07, 0x65, 0x78, 0x70, 0x06, 0x09, 0x37, 0x36, 0x31, 0x38, 0x09, 0x67, 0x6F, 0x6C, 0x64, 0x06, 0x0D, 0x37, 0x30, 0x37, 0x37, 0x37, 0x37, 0x0B, 0x73, 0x74, 0x6F, 0x6E, 0x65, 0x06, 0x07, 0x33, 0x34, 0x33, 0x0F, 0x72, 0x6F, 0x6F, 0x6D, 0x6E, 0x75, 0x6D, 0x06, 0x03, 0x33, 0x0B, 0x6F, 0x70, 0x6E, 0x75, 0x6D, 0x06, 0x07, 0x31, 0x30, 0x38, 0x0D, 0x6C, 0x65, 0x73, 0x73, 0x6F, 0x6E, 0x06, 0x03, 0x31, 0x0D, 0x67, 0x75, 0x65, 0x73, 0x74, 0x73, 0x06, 0x2B, 0x3A, 0x31, 0x32, 0x32, 0x3A, 0x31, 0x30, 0x32, 0x3A, 0x31, 0x38, 0x35, 0x3A, 0x31, 0x30, 0x34, 0x3A, 0x31, 0x30, 0x35, 0x3A, 0x05, 0x69, 0x70, 0x06, 0x15, 0x31, 0x39, 0x39, 0x39, 0x39, 0x30, 0x31, 0x32, 0x35, 0x32, 0x11, 0x73, 0x69, 0x74, 0x65, 0x64, 0x61, 0x74, 0x61, 0x06, 0x01, 0x11, 0x65, 0x76, 0x65, 0x6E, 0x74, 0x6E, 0x75, 0x6D, 0x06, 0x03, 0x30, 0x05, 0x63, 0x74, 0x06, 0x27, 0x32, 0x30, 0x31, 0x30, 0x2D, 0x30, 0x33, 0x2D, 0x32, 0x35, 0x20, 0x32, 0x31, 0x3A, 0x35, 0x35, 0x3A, 0x32, 0x38, 0x0F, 0x6C, 0x6F, 0x67, 0x69, 0x6E, 0x63, 0x74, 0x06, 0x15, 0x31, 0x32, 0x38, 0x30, 0x39, 0x36, 0x32, 0x39, 0x32, 0x31, 0x0D, 0x63, 0x75, 0x72, 0x72, 0x63, 0x74, 0x05, 0x41, 0xFFFFFFD3, 0x16, 0xFFFFFF88, 0x52, 0x00, 0x00, 0x00, 0x09, 0x73, 0x69, 0x74, 0x65, 0x09, 0x01, 0x01, 0x01, 0x0B, 0x66, 0x66, 0x6C, 0x61, 0x67, 0x06, 0x54, 0x56, 0x06, 0x27, 0x32, 0x30, 0x31, 0x30, 0x2D, 0x30, 0x37, 0x2D, 0x31, 0x35, 0x20, 0x31, 0x39, 0x3A, 0x34, 0x39, 0x3A, 0x30, 0x36, 0x01, 0x0A, 0x0B, 0x01, 0x06, 0x06, 0x0B, 0x37, 0x32, 0x31, 0x37, 0x38, 0x0A, 0x06, 0x0C, 0x0E, 0x06, 0x13, 0x32, 0x33, 0x39, 0x31, 0x37, 0x38, 0x37, 0x38, 0x36, 0x12, 0x06, 0x1B, 0xFFFFFFE5, 0xFFFFFFBC, 0xFFFFFFA0, 0xFFFFFFE6, 0xFFFFFFA2, 0xFFFFFFA6, 0xFFFFFFE5, 0xFFFFFFA9, 0xFFFFFF95, 0x4E, 0x69, 0x6E, 0x69, 0x16, 0x06, 0x05, 0x32, 0x33, 0x1A, 0x0A, 0x0B, 0x01, 0x0A, 0x06, 0x68, 0x1C, 0x06, 0x6A, 0x1E, 0x06, 0x21, 0x7A, 0x68, 0x61, 0x6E, 0x67, 0x6D, 0x65, 0x6E, 0x67, 0x6A, 0x69, 0x65, 0x4E, 0x69, 0x6E, 0x69, 0x22, 0x06, 0xFFFFFF81, 0x15, 0x68, 0x74, 0x74, 0x70, 0x3A, 0x2F, 0x2F, 0x68, 0x64, 0x6E, 0x2E, 0x78, 0x6E, 0x69, 0x6D, 0x67, 0x2E, 0x63, 0x6E, 0x2F, 0x70, 0x68, 0x6F, 0x74, 0x6F, 0x73, 0x2F, 0x68, 0x64, 0x6E, 0x31, 0x32, 0x31, 0x2F, 0x32, 0x30, 0x30, 0x39, 0x31, 0x30, 0x31, 0x31, 0x2F, 0x31, 0x36, 0x30, 0x35, 0x2F, 0x74, 0x69, 0x6E, 0x79, 0x5F, 0x45, 0x76, 0x64, 0x62, 0x5F, 0x32, 0x36, 0x38, 0x39, 0x37, 0x64, 0x30, 0x31, 0x39, 0x31, 0x31, 0x36, 0x2E, 0x6A, 0x70, 0x67, 0x26, 0x06, 0x28, 0x2A, 0x06, 0x6C, 0x01, 0x62, 0x06, 0x54, 0x56, 0x06, 0x27, 0x32, 0x30, 0x31, 0x30, 0x2D, 0x30, 0x37, 0x2D, 0x31, 0x35, 0x20, 0x32, 0x32, 0x3A, 0x32, 0x39, 0x3A, 0x30, 0x39, 0x01, 0x0A, 0x0B, 0x01, 0x06, 0x06, 0x0B, 0x38, 0x30, 0x33, 0x38, 0x36, 0x0A, 0x06, 0x0C, 0x0E, 0x06, 0x13, 0x33, 0x30, 0x39, 0x30, 0x39, 0x39, 0x37, 0x35, 0x39, 0x12, 0x06, 0x13, 0xFFFFFFE6, 0xFFFFFF9E, 0xFFFFFF97, 0xFFFFFFE6, 0xFFFFFFBC, 0xFFFFFFA2, 0xFFFFFFE5, 0xFFFFFF81, 0xFFFFFF89, 0x16, 0x06, 0x05, 0x31, 0x33, 0x1A, 0x0A, 0x0B, 0x01, 0x0A, 0x06, 0x76, 0x1C, 0x06, 0x78, 0x1E, 0x06, 0x13, 0x6C, 0x69, 0x6E, 0x68, 0x61, 0x6E, 0x77, 0x65, 0x69, 0x22, 0x06, 0xFFFFFF81, 0x15, 0x68, 0x74, 0x74, 0x70, 0x3A, 0x2F, 0x2F, 0x68, 0x64, 0x6E, 0x2E, 0x78, 0x6E, 0x69, 0x6D, 0x67, 0x2E, 0x63, 0x6E, 0x2F, 0x70, 0x68, 0x6F, 0x74, 0x6F, 0x73, 0x2F, 0x68, 0x64, 0x6E, 0x34, 0x32, 0x31, 0x2F, 0x32, 0x30, 0x31, 0x30, 0x30, 0x33, 0x32, 0x38, 0x2F, 0x31, 0x34, 0x31, 0x30, 0x2F, 0x74, 0x69, 0x6E, 0x79, 0x5F, 0x55, 0x37, 0x70, 0x4F, 0x5F, 0x31, 0x31, 0x39, 0x33, 0x38, 0x64, 0x30, 0x31, 0x39, 0x31, 0x31, 0x38, 0x2E, 0x6A, 0x70, 0x67, 0x26, 0x06, 0x37, 0x31, 0x30, 0x3A, 0x31, 0x30, 0x3A, 0x31, 0x31, 0x3A, 0x31, 0x30, 0x3A, 0x35, 0x3A, 0x31, 0x3A, 0x31, 0x31, 0x3A, 0x35, 0x3A, 0x35, 0x3A, 0x35, 0x3A, 0x31, 0x30, 0x2A, 0x06, 0x7A, 0x01, 0x62, 0x06, 0x54, 0x56, 0x06, 0x27, 0x32, 0x30, 0x31, 0x30, 0x2D, 0x30, 0x38, 0x2D, 0x30, 0x34, 0x20, 0x31, 0x35, 0x3A, 0x33, 0x34, 0x3A, 0x33, 0x36, 0x01, 0x0A, 0x0B, 0x01, 0x06, 0x06, 0x0B, 0x37, 0x33, 0x31, 0x39, 0x31, 0x0A, 0x06, 0x0C, 0x0E, 0x06, 0x13, 0x32, 0x32, 0x34, 0x37, 0x34, 0x31, 0x31, 0x33, 0x33, 0x12, 0x06, 0x0D, 0xFFFFFFE9, 0xFFFFFFA9, 0xFFFFFFAC, 0xFFFFFFE6, 0xFFFFFF95, 0xFFFFFF8F, 0x16, 0x06, 0x03, 0x37, 0x1A, 0x0A, 0x0B, 0x01, 0x0A, 0x06, 0xFFFFFF81, 0x06, 0x1C, 0x06, 0xFFFFFF81, 0x08, 0x1E, 0x06, 0x0B, 0x6D, 0x61, 0x6D, 0x69, 0x6E, 0x22, 0x06, 0xFFFFFF81, 0x15, 0x68, 0x74, 0x74, 0x70, 0x3A, 0x2F, 0x2F, 0x68, 0x64, 0x6E, 0x2E, 0x78, 0x6E, 0x69, 0x6D, 0x67, 0x2E, 0x63, 0x6E, 0x2F, 0x70, 0x68, 0x6F, 0x74, 0x6F, 0x73, 0x2F, 0x68, 0x64, 0x6E, 0x32, 0x32, 0x31, 0x2F, 0x32, 0x30, 0x30, 0x39, 0x31, 0x30, 0x32, 0x37, 0x2F, 0x32, 0x31, 0x33, 0x35, 0x2F, 0x74, 0x69, 0x6E, 0x79, 0x5F, 0x51, 0x77, 0x41, 0x51, 0x5F, 0x31, 0x35, 0x34, 0x33, 0x36, 0x6B, 0x30, 0x31, 0x39, 0x31, 0x31, 0x38, 0x2E, 0x6A, 0x70, 0x67, 0x26, 0x06, 0x28, 0x2A, 0x06, 0xFFFFFF81, 0x0A, 0x06, 0x06, 0x0B, 0x33, 0x39, 0x30, 0x34, 0x36, 0x2E, 0x04, 0x00, 0x30, 0x06, 0x07, 0x33, 0x32, 0x39, 0x34, 0x06, 0x09, 0x33, 0x34, 0x37, 0x32, 0x38, 0x06, 0x54, 0x3C, 0x06, 0x3E, 0x40, 0x06, 0x05, 0x32, 0x31, 0x44, 0x06, 0x46, 0x48, 0x06, 0x2B, 0x3A, 0x31, 0x32, 0x31, 0x3A, 0x31, 0x37, 0x32, 0x3A, 0x31, 0x37, 0x39, 0x3A, 0x31, 0x30, 0x37, 0x3A, 0x31, 0x30, 0x35, 0x3A, 0x4C, 0x06, 0x54, 0x50, 0x06, 0x01, 0x52, 0x06, 0x54, 0x56, 0x06, 0x27, 0x32, 0x30, 0x31, 0x30, 0x2D, 0x30, 0x36, 0x2D, 0x30, 0x32, 0x20, 0x31, 0x37, 0x3A, 0x30, 0x33, 0x3A, 0x31, 0x39, 0x5A, 0x06, 0x15, 0x31, 0x32, 0x37, 0x39, 0x34, 0x31, 0x36, 0x34, 0x32, 0x31, 0x5E, 0x05, 0x41, 0xFFFFFFD3, 0x16, 0xFFFFFF88, 0x66, 0x00, 0x00, 0x00, 0x60, 0x09, 0x01, 0x01, 0x01, 0x62, 0x06, 0x54, 0x56, 0x06, 0x27, 0x32, 0x30, 0x31, 0x30, 0x2D, 0x30, 0x37, 0x2D, 0x31, 0x38, 0x20, 0x30, 0x39, 0x3A, 0x32, 0x36, 0x3A, 0x33, 0x35, 0x01, 0x0A, 0x0B, 0x01, 0x06, 0x06, 0x0B, 0x38, 0x30, 0x33, 0x38, 0x33, 0x0A, 0x06, 0x0C, 0x0E, 0x06, 0x13, 0x32, 0x37, 0x30, 0x30, 0x32, 0x38, 0x38, 0x31, 0x34, 0x12, 0x06, 0x13, 0xFFFFFFE5, 0xFFFFFFAD, 0xFFFFFF99, 0xFFFFFFE8, 0xFFFFFF99, 0xFFFFFFB9, 0xFFFFFFE8, 0xFFFFFF94, 0xFFFFFF9A, 0x16, 0x06, 0x03, 0x32, 0x1A, 0x0A, 0x0B, 0x01, 0x0A, 0x06, 0xFFFFFF81, 0x22, 0x1C, 0x06, 0xFFFFFF81, 0x24, 0x1E, 0x06, 0x15, 0x73, 0x75, 0x6E, 0x68, 0x6F, 0x6E, 0x67, 0x77, 0x65, 0x69, 0x22, 0x06, 0xFFFFFF81, 0x17, 0x68, 0x74, 0x74, 0x70, 0x3A, 0x2F, 0x2F, 0x68, 0x64, 0x6E, 0x2E, 0x78, 0x6E, 0x69, 0x6D, 0x67, 0x2E, 0x63, 0x6E, 0x2F, 0x70, 0x68, 0x6F, 0x74, 0x6F, 0x73, 0x2F, 0x68, 0x64, 0x6E, 0x34, 0x32, 0x31, 0x2F, 0x32, 0x30, 0x31, 0x30, 0x30, 0x36, 0x31, 0x37, 0x2F, 0x31, 0x33, 0x30, 0x35, 0x2F, 0x74, 0x69, 0x6E, 0x79, 0x5F, 0x45, 0x61, 0x41, 0x34, 0x5F, 0x31, 0x31, 0x37, 0x31, 0x38, 0x32, 0x6E, 0x30, 0x31, 0x39, 0x31, 0x31, 0x38, 0x2E, 0x6A, 0x70, 0x67, 0x26, 0x06, 0x28, 0x2A, 0x06, 0xFFFFFF81, 0x26, 0x01, 0x62, 0x06, 0x54, 0x56, 0x06, 0xFFFFFF81, 0x02, 0x01, 0x0A, 0x0B, 0x01, 0x06, 0x06, 0x0B, 0x38, 0x30, 0x33, 0x38, 0x34, 0x0A, 0x06, 0x0C, 0x0E, 0x06, 0x13, 0x32, 0x38, 0x37, 0x31, 0x30, 0x38, 0x32, 0x39, 0x30, 0x12, 0x06, 0x13, 0xFFFFFFE5, 0xFFFFFFB4, 0xFFFFFF94, 0xFFFFFFE7, 0xFFFFFFBE, 0xFFFFFFBD, 0xFFFFFFE9, 0xFFFFFFB9, 0xFFFFFFAD, 0x16, 0x06, 0xFFFFFF81, 0x26, 0x1A, 0x0A, 0x0B, 0x01, 0x0A, 0x06, 0xFFFFFF81, 0x2E, 0x1C, 0x06, 0xFFFFFF81, 0x30, 0x1E, 0x06, 0x0F, 0x63, 0x75, 0x69, 0x79, 0x75, 0x6C, 0x75, 0x22, 0x06, 0xFFFFFF81, 0x15, 0x68, 0x74, 0x74, 0x70, 0x3A, 0x2F, 0x2F, 0x68, 0x64, 0x6E, 0x2E, 0x78, 0x6E, 0x69, 0x6D, 0x67, 0x2E, 0x63, 0x6E, 0x2F, 0x70, 0x68, 0x6F, 0x74, 0x6F, 0x73, 0x2F, 0x68, 0x64, 0x6E, 0x33, 0x32, 0x31, 0x2F, 0x32, 0x30, 0x31, 0x30, 0x30, 0x34, 0x31, 0x30, 0x2F, 0x31, 0x38, 0x30, 0x35, 0x2F, 0x74, 0x69, 0x6E, 0x79, 0x5F, 0x6F, 0x52, 0x38, 0x51, 0x5F, 0x38, 0x30, 0x32, 0x32, 0x33, 0x6A, 0x30, 0x31, 0x39, 0x31, 0x31, 0x37, 0x2E, 0x6A, 0x70, 0x67, 0x26, 0x06, 0x28, 0x2A, 0x06, 0xFFFFFF81, 0x26, 0x01, 0x62, 0x06, 0x54, 0x56, 0x06, 0xFFFFFF81, 0x02, 0x01, 0x0A, 0x0B, 0x01, 0x0A, 0x06, 0x0C, 0x0E, 0x06, 0x0C, 0x12, 0x06, 0x19, 0xFFFFFFE7, 0xFFFFFF8E, 0xFFFFFF8B, 0xFFFFFFE4, 0xFFFFFFBC, 0xFFFFFF9F, 0xFFFFFFE4, 0xFFFFFFBC, 0xFFFFFF9F, 0x5E, 0x2D, 0x5E, 0x16, 0x06, 0xFFFFFF81, 0x26, 0x1A, 0x0A, 0x0B, 0x01, 0x06, 0x06, 0x0B, 0x34, 0x37, 0x33, 0x33, 0x31, 0x0A, 0x06, 0x0C, 0x1C, 0x06, 0xFFFFFF81, 0x36, 0x1E, 0x06, 0x1B, 0x77, 0x61, 0x6E, 0x67, 0x77, 0x65, 0x69, 0x77, 0x65, 0x69, 0x5E, 0x2D, 0x5E, 0x2E, 0x04, 0x00, 0x22, 0x06, 0xFFFFFF81, 0x21, 0x68, 0x74, 0x74, 0x70, 0x3A, 0x2F, 0x2F, 0x68, 0x64, 0x6E, 0x2E, 0x78, 0x6E, 0x69, 0x6D, 0x67, 0x2E, 0x63, 0x6E, 0x2F, 0x70, 0x68, 0x6F, 0x74, 0x6F, 0x73, 0x2F, 0x68, 0x64, 0x6E, 0x33, 0x32, 0x31, 0x2F, 0x32, 0x30, 0x31, 0x30, 0x30, 0x34, 0x32, 0x36, 0x2F, 0x30, 0x39, 0x33, 0x35, 0x2F, 0x68, 0x5F, 0x74, 0x69, 0x6E, 0x79, 0x5F, 0x68, 0x4B, 0x53, 0x35, 0x5F, 0x36, 0x36, 0x66, 0x34, 0x30, 0x30, 0x30, 0x30, 0x64, 0x38, 0x62, 0x34, 0x32, 0x66, 0x37, 0x34, 0x2E, 0x6A, 0x70, 0x67, 0x26, 0x06, 0x28, 0x2A, 0x06, 0xFFFFFF81, 0x26, 0x30, 0x06, 0x05, 0x31, 0x34, 0x34, 0x06, 0x07, 0x38, 0x31, 0x30, 0x38, 0x06, 0x05, 0x34, 0x35, 0x3C, 0x06, 0x3E, 0x40, 0x06, 0x05, 0x31, 0x30, 0x44, 0x06, 0x46, 0x48, 0x06, 0x2B, 0x3A, 0x31, 0x31, 0x33, 0x3A, 0x31, 0x30, 0x32, 0x3A, 0x31, 0x30, 0x33, 0x3A, 0x31, 0x30, 0x34, 0x3A, 0x31, 0x30, 0x35, 0x3A, 0x4C, 0x06, 0x54, 0x50, 0x06, 0x01, 0x52, 0x06, 0x54, 0x56, 0x06, 0x27, 0x32, 0x30, 0x31, 0x30, 0x2D, 0x30, 0x37, 0x2D, 0x31, 0x35, 0x20, 0x31, 0x34, 0x3A, 0x35, 0x31, 0x3A, 0x34, 0x36, 0x5A, 0x06, 0x15, 0x31, 0x32, 0x38, 0x30, 0x39, 0x37, 0x35, 0x30, 0x34, 0x31, 0x5E, 0x05, 0x41, 0xFFFFFFD3, 0x16, 0xFFFFFF88, 0xFFFFFF81, 0x40, 0x00, 0x00, 0x60, 0x09, 0x01, 0x01, 0x01, 0x62, 0x04, 0x00, 0x01, 0x0A, 0x0B, 0x01, 0x06, 0x06, 0x0B, 0x38, 0x30, 0x33, 0x38, 0x32, 0x0A, 0x06, 0x0C, 0x0E, 0x06, 0x13, 0x32, 0x36, 0x39, 0x34, 0x33, 0x36, 0x38, 0x38, 0x30, 0x12, 0x06, 0x1F, 0xFFFFFFE5, 0xFFFFFF88, 0xFFFFFF98, 0xFFFFFFE5, 0xFFFFFFB0, 0xFFFFFF8F, 0xFFFFFFE5, 0xFFFFFFAE, 0xFFFFFF81, 0x6C, 0xFFFFFFE2, 0xFFFFFF99, 0xFFFFFFA1, 0x76, 0x65, 0x16, 0x06, 0xFFFFFF81, 0x26, 0x1A, 0x0A, 0x0B, 0x01, 0x0A, 0x06, 0xFFFFFF81, 0x4E, 0x1C, 0x06, 0xFFFFFF81, 0x50, 0x1E, 0x06, 0x23, 0x6C, 0x69, 0x75, 0x78, 0x69, 0x61, 0x6F, 0x6E, 0x69, 0x6E, 0x67, 0x6C, 0xFFFFFFE2, 0xFFFFFF99, 0xFFFFFFA1, 0x76, 0x65, 0x22, 0x06, 0xFFFFFF81, 0x13, 0x68, 0x74, 0x74, 0x70, 0x3A, 0x2F, 0x2F, 0x68, 0x64, 0x6E, 0x2E, 0x78, 0x6E, 0x69, 0x6D, 0x67, 0x2E, 0x63, 0x6E, 0x2F, 0x70, 0x68, 0x6F, 0x74, 0x6F, 0x73, 0x2F, 0x68, 0x64, 0x6E, 0x33, 0x31, 0x31, 0x2F, 0x32, 0x30, 0x30, 0x39, 0x30, 0x36, 0x32, 0x36, 0x2F, 0x30, 0x31, 0x33, 0x35, 0x2F, 0x74, 0x69, 0x6E, 0x79, 0x5F, 0x34, 0x36, 0x33, 0x34, 0x5F, 0x33, 0x36, 0x33, 0x39, 0x63, 0x32, 0x30, 0x34, 0x32, 0x33, 0x35, 0x2E, 0x6A, 0x70, 0x67, 0x26, 0x06, 0x28, 0x2A, 0x06, 0xFFFFFF81, 0x26, 0x01, 0x62, 0x06, 0x54, 0x56, 0x06, 0xFFFFFF81, 0x02, 0x01, 0x0A, 0x0B, 0x01, 0x06, 0x06, 0x0B, 0x38, 0x30, 0x33, 0x38, 0x37, 0x0A, 0x06, 0x0C, 0x0E, 0x06, 0x13, 0x37, 0x32, 0x37, 0x31, 0x37, 0x38, 0x38, 0x33, 0x32, 0x12, 0x06, 0x0D, 0xFFFFFFE8, 0xFFFFFFB5, 0xFFFFFFB5, 0xFFFFFFE4, 0xFFFFFFBC, 0xFFFFFF9F, 0x16, 0x06, 0xFFFFFF81, 0x26, 0x1A, 0x0A, 0x0B, 0x01, 0x0A, 0x06, 0xFFFFFF81, 0x58, 0x1C, 0x06, 0xFFFFFF81, 0x5A, 0x1E, 0x06, 0x0F, 0x7A, 0x68, 0x61, 0x6F, 0x77, 0x65, 0x69, 0x22, 0x06, 0xFFFFFF81, 0x1F, 0x68, 0x74, 0x74, 0x70, 0x3A, 0x2F, 0x2F, 0x68, 0x64, 0x6E, 0x31, 0x30, 0x31, 0x2E, 0x72, 0x72, 0x69, 0x6D, 0x67, 0x2E, 0x63, 0x6F, 0x6D, 0x2F, 0x70, 0x68, 0x6F, 0x74, 0x6F, 0x73, 0x2F, 0x68, 0x64, 0x6E, 0x31, 0x30, 0x31, 0x2F, 0x32, 0x30, 0x30, 0x39, 0x30, 0x38, 0x30, 0x38, 0x2F, 0x31, 0x30, 0x2F, 0x32, 0x30, 0x2F, 0x74, 0x69, 0x6E, 0x79, 0x5F, 0x57, 0x53, 0x6D, 0x46, 0x5F, 0x37, 0x37, 0x35, 0x39, 0x30, 0x68, 0x32, 0x30, 0x36, 0x31, 0x33, 0x33, 0x2E, 0x6A, 0x70, 0x67, 0x26, 0x06, 0x28, 0x2A, 0x06, 0xFFFFFF81, 0x26, 0x01, 0x62, 0x06, 0x54, 0x56, 0x06, 0xFFFFFF81, 0x02, 0x01, 0x0A, 0x0B, 0x01, 0x06, 0x06, 0x0B, 0x38, 0x30, 0x33, 0x38, 0x35, 0x0A, 0x06, 0x0C, 0x0E, 0x06, 0x13, 0x32, 0x39, 0x39, 0x38, 0x31, 0x36, 0x37, 0x30, 0x39, 0x12, 0x06, 0x0D, 0xFFFFFFE5, 0xFFFFFF88, 0xFFFFFF98, 0xFFFFFFE8, 0xFFFFFFB6, 0xFFFFFF85, 0x16, 0x06, 0xFFFFFF81, 0x26, 0x1A, 0x0A, 0x0B, 0x01, 0x0A, 0x06, 0xFFFFFF81, 0x62, 0x1C, 0x06, 0xFFFFFF81, 0x64, 0x1E, 0x06, 0x0F, 0x6C, 0x69, 0x75, 0x63, 0x68, 0x61, 0x6F, 0x22, 0x06, 0x5F, 0x68, 0x74, 0x74, 0x70, 0x3A, 0x2F, 0x2F, 0x68, 0x65, 0x61, 0x64, 0x2E, 0x78, 0x69, 0x61, 0x6F, 0x6E, 0x65, 0x69, 0x2E, 0x63, 0x6F, 0x6D, 0x2F, 0x70, 0x68, 0x6F, 0x74, 0x6F, 0x73, 0x2F, 0x30, 0x2F, 0x30, 0x2F, 0x6D, 0x65, 0x6E, 0x5F, 0x74, 0x69, 0x6E, 0x79, 0x2E, 0x67, 0x69, 0x66, 0x26, 0x06, 0x28, 0x2A, 0x06, 0xFFFFFF81, 0x26, 0x01, 0x62, 0x06, 0x54, 0x56, 0x06, 0xFFFFFF81, 0x02, 0x01, 0x0A, 0x0B, 0x01, 0x06, 0x06, 0x0B, 0x38, 0x30, 0x33, 0x38, 0x30, 0x0A, 0x06, 0x0C, 0x0E, 0x06, 0x13, 0x32, 0x36, 0x31, 0x38, 0x36, 0x31, 0x38, 0x33, 0x38, 0x12, 0x06, 0x13, 0xFFFFFFE8, 0xFFFFFFB5, 0xFFFFFFB5, 0xFFFFFFE4, 0xFFFFFFB8, 0xFFFFFF9C, 0xFFFFFFE6, 0xFFFFFF96, 0xFFFFFFB9, 0x16, 0x06, 0xFFFFFF81, 0x26, 0x1A, 0x0A, 0x0B, 0x01, 0x0A, 0x06, 0xFFFFFF81, 0x6C, 0x1C, 0x06, 0xFFFFFF81, 0x6E, 0x1E, 0x06, 0x19, 0x7A, 0x68, 0x61, 0x6F, 0x64, 0x6F, 0x6E, 0x67, 0x66, 0x61, 0x6E, 0x67, 0x22, 0x06, 0xFFFFFF81, 0x13, 0x68, 0x74, 0x74, 0x70, 0x3A, 0x2F, 0x2F, 0x68, 0x64, 0x6E, 0x2E, 0x78, 0x6E, 0x69, 0x6D, 0x67, 0x2E, 0x63, 0x6E, 0x2F, 0x70, 0x68, 0x6F, 0x74, 0x6F, 0x73, 0x2F, 0x68, 0x64, 0x6E, 0x33, 0x30, 0x31, 0x2F, 0x32, 0x30, 0x30, 0x39, 0x30, 0x31, 0x31, 0x33, 0x2F, 0x30, 0x38, 0x2F, 0x33, 0x35, 0x2F, 0x74, 0x69, 0x6E, 0x79, 0x5F, 0x61, 0x64, 0x61, 0x67, 0x5F, 0x31, 0x33, 0x34, 0x65, 0x32, 0x30, 0x34, 0x30, 0x39, 0x36, 0x2E, 0x6A, 0x70, 0x67, 0x26, 0x06, 0x28, 0x2A, 0x06, 0xFFFFFF81, 0x26, 0x01, 0x62, 0x06, 0x54, 0x56, 0x06, 0xFFFFFF81, 0x02, 0x01, 0x0A, 0x0B, 0x01, 0x06, 0x06, 0x0B, 0x38, 0x30, 0x33, 0x37, 0x34, 0x0A, 0x06, 0x0C, 0x0E, 0x06, 0x13, 0x32, 0x32, 0x38, 0x30, 0x34, 0x39, 0x37, 0x36, 0x32, 0x12, 0x06, 0x13, 0xFFFFFFE5, 0xFFFFFFBC, 0xFFFFFFA0, 0xFFFFFFE6, 0xFFFFFF96, 0xFFFFFF87, 0xFFFFFFE6, 0xFFFFFF99, 0xFFFFFFB6, 0x16, 0x06, 0xFFFFFF81, 0x26, 0x1A, 0x0A, 0x0B, 0x01, 0x0A, 0x06, 0xFFFFFF81, 0x76, 0x1C, 0x06, 0xFFFFFF81, 0x78, 0x1E, 0x06, 0x19, 0x7A, 0x68, 0x61, 0x6E, 0x67, 0x77, 0x65, 0x6E, 0x6A, 0x69, 0x6E, 0x67, 0x22, 0x06, 0xFFFFFF81, 0x15, 0x68, 0x74, 0x74, 0x70, 0x3A, 0x2F, 0x2F, 0x68, 0x64, 0x6E, 0x2E, 0x78, 0x6E, 0x69, 0x6D, 0x67, 0x2E, 0x63, 0x6E, 0x2F, 0x70, 0x68, 0x6F, 0x74, 0x6F, 0x73, 0x2F, 0x68, 0x64, 0x6E, 0x34, 0x32, 0x31, 0x2F, 0x32, 0x30, 0x31, 0x30, 0x30, 0x33, 0x31, 0x33, 0x2F, 0x31, 0x39, 0x31, 0x35, 0x2F, 0x74, 0x69, 0x6E, 0x79, 0x5F, 0x37, 0x58, 0x45, 0x66, 0x5F, 0x33, 0x37, 0x34, 0x32, 0x32, 0x65, 0x30, 0x31, 0x39, 0x31, 0x31, 0x38, 0x2E, 0x6A, 0x70, 0x67, 0x26, 0x06, 0x28, 0x2A, 0x06, 0xFFFFFF81, 0x26, 0x01, 0x62, 0x06, 0x54, 0x56, 0x06, 0xFFFFFF81, 0x02, 0x01, 0x0A, 0x0B, 0x01, 0x06, 0x06, 0x0B, 0x37, 0x35, 0x39, 0x37, 0x30, 0x0A, 0x06, 0x0C, 0x0E, 0x06, 0x13, 0x32, 0x36, 0x39, 0x35, 0x33, 0x35, 0x37, 0x35, 0x31, 0x12, 0x06, 0x0D, 0xFFFFFFE5, 0xFFFFFFBC, 0xFFFFFFA0, 0xFFFFFFE7, 0xFFFFFF90, 0xFFFFFF9B, 0x16, 0x06, 0xFFFFFF81, 0x26, 0x1A, 0x0A, 0x0B, 0x01, 0x0A, 0x06, 0xFFFFFF82, 0x00, 0x1C, 0x06, 0xFFFFFF82, 0x02, 0x1E, 0x06, 0x13, 0x7A, 0x68, 0x61, 0x6E, 0x67, 0x63, 0x68, 0x65, 0x6E, 0x22, 0x06, 0xFFFFFF81, 0x15, 0x68, 0x74, 0x74, 0x70, 0x3A, 0x2F, 0x2F, 0x68, 0x64, 0x6E, 0x2E, 0x78, 0x6E, 0x69, 0x6D, 0x67, 0x2E, 0x63, 0x6E, 0x2F, 0x70, 0x68, 0x6F, 0x74, 0x6F, 0x73, 0x2F, 0x68, 0x64, 0x6E, 0x33, 0x32, 0x31, 0x2F, 0x32, 0x30, 0x30, 0x39, 0x31, 0x31, 0x31, 0x38, 0x2F, 0x31, 0x33, 0x35, 0x35, 0x2F, 0x74, 0x69, 0x6E, 0x79, 0x5F, 0x36, 0x4C, 0x72, 0x50, 0x5F, 0x34, 0x30, 0x33, 0x30, 0x34, 0x6E, 0x30, 0x31, 0x39, 0x31, 0x31, 0x38, 0x2E, 0x6A, 0x70, 0x67, 0x26, 0x06, 0x28, 0x2A, 0x06, 0xFFFFFF81, 0x26, 0x01, 0x62, 0x06, 0x54, 0x56, 0x06, 0x27, 0x32, 0x30, 0x31, 0x30, 0x2D, 0x30, 0x37, 0x2D, 0x32, 0x34, 0x20, 0x31, 0x30, 0x3A, 0x30, 0x35, 0x3A, 0x33, 0x37, 0x01, 0x0A, 0x0B, 0x01, 0x06, 0x06, 0x0B, 0x38, 0x30, 0x33, 0x38, 0x31, 0x0A, 0x06, 0x0C, 0x0E, 0x06, 0x13, 0x32, 0x36, 0x36, 0x32, 0x33, 0x34, 0x37, 0x38, 0x31, 0x12, 0x06, 0x0D, 0xFFFFFFE6, 0xFFFFFFB2, 0xFFFFFF88, 0xFFFFFFE6, 0xFFFFFF99, 0xFFFFFF97, 0x16, 0x06, 0xFFFFFF81, 0x26, 0x1A, 0x0A, 0x0B, 0x01, 0x0A, 0x06, 0xFFFFFF82, 0x0C, 0x1C, 0x06, 0xFFFFFF82, 0x0E, 0x1E, 0x06, 0x0F, 0x73, 0x68, 0x65, 0x6E, 0x68, 0x61, 0x6E, 0x22, 0x06, 0xFFFFFF81, 0x17, 0x68, 0x74, 0x74, 0x70, 0x3A, 0x2F, 0x2F, 0x68, 0x64, 0x6E, 0x2E, 0x78, 0x6E, 0x69, 0x6D, 0x67, 0x2E, 0x63, 0x6E, 0x2F, 0x70, 0x68, 0x6F, 0x74, 0x6F, 0x73, 0x2F, 0x68, 0x64, 0x6E, 0x33, 0x31, 0x31, 0x2F, 0x32, 0x30, 0x30, 0x39, 0x30, 0x32, 0x31, 0x30, 0x2F, 0x32, 0x31, 0x2F, 0x32, 0x35, 0x2F, 0x74, 0x69, 0x6E, 0x79, 0x5F, 0x6C, 0x73, 0x39, 0x76, 0x5F, 0x38, 0x36, 0x34, 0x30, 0x37, 0x61, 0x32, 0x30, 0x34, 0x32, 0x33, 0x34, 0x2E, 0x6A, 0x70, 0x67, 0x26, 0x06, 0x28, 0x2A, 0x06, 0xFFFFFF81, 0x26, 0x01, 0x62, 0x06, 0x54, 0x56, 0x06, 0xFFFFFF81, 0x02, 0x01, 0x0A, 0x0B, 0x01, 0x06, 0x06, 0x0B, 0x38, 0x30, 0x33, 0x37, 0x35, 0x0A, 0x06, 0x0C, 0x0E, 0x06, 0x13, 0x32, 0x34, 0x32, 0x30, 0x32, 0x37, 0x38, 0x31, 0x37, 0x12, 0x06, 0x0D, 0xFFFFFFE5, 0xFFFFFF88, 0xFFFFFF98, 0xFFFFFFE4, 0xFFFFFFB8, 0xFFFFFF9B, 0x16, 0x06, 0xFFFFFF81, 0x26, 0x1A, 0x0A, 0x0B, 0x01, 0x0A, 0x06, 0xFFFFFF82, 0x16, 0x1C, 0x06, 0xFFFFFF82, 0x18, 0x1E, 0x06, 0x0F, 0x6C, 0x69, 0x75, 0x63, 0x6F, 0x6E, 0x67, 0x22, 0x06, 0xFFFFFF81, 0x15, 0x68, 0x74, 0x74, 0x70, 0x3A, 0x2F, 0x2F, 0x68, 0x64, 0x6E, 0x2E, 0x78, 0x6E, 0x69, 0x6D, 0x67, 0x2E, 0x63, 0x6E, 0x2F, 0x70, 0x68, 0x6F, 0x74, 0x6F, 0x73, 0x2F, 0x68, 0x64, 0x6E, 0x31, 0x32, 0x31, 0x2F, 0x32, 0x30, 0x31, 0x30, 0x30, 0x36, 0x30, 0x35, 0x2F, 0x32, 0x32, 0x33, 0x30, 0x2F, 0x74, 0x69, 0x6E, 0x79, 0x5F, 0x4C, 0x4B, 0x53, 0x43, 0x5F, 0x35, 0x31, 0x36, 0x33, 0x36, 0x65, 0x30, 0x31, 0x39, 0x31, 0x31, 0x37, 0x2E, 0x6A, 0x70, 0x67, 0x26, 0x06, 0x28, 0x2A, 0x06, 0xFFFFFF81, 0x26, 0x01, 0x62, 0x06, 0x54, 0x56, 0x06, 0xFFFFFF81, 0x02, 0x01, 0x0A, 0x0B, 0x01, 0x06, 0x06, 0x0B, 0x38, 0x30, 0x33, 0x37, 0x36, 0x0A, 0x06, 0x0C, 0x0E, 0x06, 0x13, 0x32, 0x34, 0x33, 0x37, 0x32, 0x30, 0x36, 0x35, 0x32, 0x12, 0x06, 0x13, 0xFFFFFFE6, 0xFFFFFF9D, 0xFFFFFF8E, 0xFFFFFFE6, 0xFFFFFF96, 0xFFFFFF87, 0xFFFFFFE5, 0xFFFFFFA8, 0xFFFFFF9F, 0x16, 0x06, 0xFFFFFF81, 0x26, 0x1A, 0x0A, 0x0B, 0x01, 0x0A, 0x06, 0xFFFFFF82, 0x20, 0x1C, 0x06, 0xFFFFFF82, 0x22, 0x1E, 0x06, 0x13, 0x6C, 0x69, 0x77, 0x65, 0x6E, 0x6A, 0x75, 0x61, 0x6E, 0x22, 0x06, 0xFFFFFF81, 0x09, 0x68, 0x74, 0x74, 0x70, 0x3A, 0x2F, 0x2F, 0x68, 0x64, 0x31, 0x35, 0x2E, 0x78, 0x69, 0x61, 0x6F, 0x6E, 0x65, 0x69, 0x2E, 0x63, 0x6F, 0x6D, 0x2F, 0x70, 0x68, 0x6F, 0x74, 0x6F, 0x73, 0x2F, 0x68, 0x64, 0x31, 0x35, 0x2F, 0x32, 0x30, 0x30, 0x38, 0x30, 0x35, 0x33, 0x31, 0x2F, 0x32, 0x30, 0x2F, 0x34, 0x31, 0x2F, 0x74, 0x69, 0x6E, 0x79, 0x5F, 0x37, 0x39, 0x39, 0x38, 0x65, 0x31, 0x35, 0x30, 0x2E, 0x6A, 0x70, 0x67, 0x26, 0x06, 0x28, 0x2A, 0x06, 0xFFFFFF81, 0x26, 0x01, 0x62, 0x06, 0x54, 0x56, 0x06, 0xFFFFFF81, 0x02, 0x01, 0x0A, 0x0B, 0x01, 0x06, 0x06, 0x0B, 0x38, 0x30, 0x33, 0x37, 0x38, 0x0A, 0x06, 0x0C, 0x0E, 0x06, 0x13, 0x32, 0x35, 0x30, 0x35, 0x30, 0x30, 0x36, 0x34, 0x39, 0x12, 0x06, 0x1B, 0xFFFFFFE9, 0xFFFFFF92, 0xFFFFFF9F, 0xFFFFFFE6, 0xFFFFFF81, 0xFFFFFF92, 0xFFFFFFE6, 0xFFFFFF98, 0xFFFFFFA5, 0x40, 0xFFFFFFE8, 0xFFFFFF82, 0xFFFFFF89, 0x16, 0x06, 0xFFFFFF81, 0x26, 0x1A, 0x0A, 0x0B, 0x01, 0x0A, 0x06, 0xFFFFFF82, 0x2A, 0x1C, 0x06, 0xFFFFFF82, 0x2C, 0x1E, 0x06, 0x23, 0x7A, 0x68, 0x6F, 0x6E, 0x67, 0x68, 0x65, 0x6E, 0x67, 0x63, 0x68, 0x75, 0x6E, 0x40, 0x72, 0x6F, 0x75, 0x22, 0x06, 0xFFFFFF81, 0x17, 0x68, 0x74, 0x74, 0x70, 0x3A, 0x2F, 0x2F, 0x68, 0x64, 0x6E, 0x2E, 0x78, 0x6E, 0x69, 0x6D, 0x67, 0x2E, 0x63, 0x6E, 0x2F, 0x70, 0x68, 0x6F, 0x74, 0x6F, 0x73, 0x2F, 0x68, 0x64, 0x6E, 0x32, 0x31, 0x31, 0x2F, 0x32, 0x30, 0x30, 0x39, 0x30, 0x32, 0x32, 0x33, 0x2F, 0x31, 0x37, 0x2F, 0x30, 0x30, 0x2F, 0x74, 0x69, 0x6E, 0x79, 0x5F, 0x45, 0x4D, 0x68, 0x78, 0x5F, 0x32, 0x39, 0x39, 0x33, 0x37, 0x62, 0x32, 0x30, 0x34, 0x32, 0x33, 0x38, 0x2E, 0x6A, 0x70, 0x67, 0x26, 0x06, 0x28, 0x2A, 0x06, 0xFFFFFF81, 0x26, 0x01, 0x62, 0x06, 0x54, 0x56, 0x06, 0xFFFFFF81, 0x02, 0x01, 0x0A, 0x0B, 0x01, 0x06, 0x06, 0x0B, 0x38, 0x30, 0x33, 0x37, 0x37, 0x0A, 0x06, 0x0C, 0x0E, 0x06, 0x13, 0x32, 0x34, 0x34, 0x39, 0x35, 0x32, 0x32, 0x39, 0x38, 0x12, 0x06, 0x21, 0xFFFFFFE7, 0xFFFFFF8E, 0xFFFFFF8B, 0xFFFFFFE6, 0xFFFFFF98, 0xFFFFFFB1, 0xFFFFFFE6, 0xFFFFFF99, 0xFFFFFF93, 0xFFFFFFE2, 0xFFFFFF9D, 0xFFFFFFA4, 0x50, 0x69, 0x6E, 0x6B, 0x16, 0x06, 0x46, 0x1A, 0x0A, 0x0B, 0x01, 0x0A, 0x06, 0xFFFFFF82, 0x34, 0x1C, 0x06, 0xFFFFFF82, 0x36, 0x1E, 0x06, 0x23, 0x77, 0x61, 0x6E, 0x67, 0x79, 0x75, 0x78, 0x69, 0x61, 0x6F, 0xFFFFFFE2, 0xFFFFFF9D, 0xFFFFFFA4, 0x50, 0x69, 0x6E, 0x6B, 0x22, 0x06, 0xFFFFFF81, 0x15, 0x68, 0x74, 0x74, 0x70, 0x3A, 0x2F, 0x2F, 0x68, 0x64, 0x6E, 0x2E, 0x78, 0x6E, 0x69, 0x6D, 0x67, 0x2E, 0x63, 0x6E, 0x2F, 0x70, 0x68, 0x6F, 0x74, 0x6F, 0x73, 0x2F, 0x68, 0x64, 0x6E, 0x33, 0x32, 0x31, 0x2F, 0x32, 0x30, 0x31, 0x30, 0x30, 0x32, 0x31, 0x34, 0x2F, 0x32, 0x33, 0x30, 0x30, 0x2F, 0x74, 0x69, 0x6E, 0x79, 0x5F, 0x37, 0x63, 0x58, 0x57, 0x5F, 0x38, 0x34, 0x35, 0x39, 0x36, 0x68, 0x30, 0x31, 0x39, 0x31, 0x31, 0x36, 0x2E, 0x6A, 0x70, 0x67, 0x26, 0x06, 0x28, 0x2A, 0x06, 0x46, 0x01, 0x62, 0x06, 0x54, 0x56, 0x06, 0xFFFFFF81, 0x02, 0x01, 0x01};
		InputStream in = new ByteArrayInputStream(bb);

		ActionMessage am = new ActionMessage();
		AmfMessageDeserializer amd = new AmfMessageDeserializer();
		amd.initialize(new SerializationContext(), in, null);
		amd.readMessage(am, new ActionContext());
		List l = am.getBodies();

		MessageBody d =(MessageBody)l.get(0);
		ASObject ao = (ASObject)d.getData();
//		ASObject ao = (ASObject) ((MessageBody)l.get(0));
		Object o = ao.get("flist");
		System.out.println(Array.get(o, 0));
	}
	
	public static void main(String[] args){
		try {
			new AmfTest().testOnlineTimeAward();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void testOnlineTimeAward() throws ClassNotFoundException, IOException {
		SerializationContext serializationContext = new SerializationContext();
		URL url = new URL("http://index.baidu.com/gateway.php");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-amf");
		conn.setRequestProperty("Referer", "http://index.baidu.com/fla/TrendAnalyser.swf");
		conn.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows 2000)");
		conn.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
//		conn.setRequestProperty("Host", "index.baidu.com");
//		conn.setRequestProperty("Cookie", "BAIDUID=21F1C4701464833E6DE5B1A44CA50CBC:FG=1; BDUSS=TFJeGxLbFFmZnFaWnZaMUFZZkpGRXdMbXRQcnZIUFA4RkVGY3EtODFrcDdnbzFOQUFBQUFBJCQAAAAAAAAAAApBLZ8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADEwLjM2LjE5LjQ1AAAAAADgTQ0kAAAAAHv1ZU179WVNb");  
		conn.connect();
		OutputStream outputStream = conn.getOutputStream();

		ActionContext actionContext = new ActionContext();
		ActionMessage requestMessage = new ActionMessage(3);

		MessageBody messageBody = new MessageBody("DataAccessor.getIndexes", "/1",
				new Object[]{"新少林寺","0","","321869291440940ae2","016022606464389e57d9dfa8e618dd0743ed008318"});
		requestMessage.addBody(messageBody);
		actionContext.setRequestMessage(requestMessage);

		ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();
		AmfMessageSerializer amfMessageSerializer = new AmfMessageSerializer();
		amfMessageSerializer.initialize(serializationContext, outBuffer, null);
		amfMessageSerializer.writeMessage(requestMessage);

		outBuffer.writeTo(outputStream);
		outBuffer.flush();
		outBuffer.close();

		InputStream inputStream = conn.getInputStream();
		BufferedInputStream urlConnectionInputStream = new BufferedInputStream(
				inputStream);
		urlConnectionInputStream.mark(2);
		ActionMessage message = new ActionMessage(3);
		actionContext.setRequestMessage(message);
		MessageDeserializer deserializer = new AmfMessageDeserializer();
		deserializer.initialize(serializationContext, urlConnectionInputStream,
				null);
		deserializer.readMessage(message, actionContext);
		Object result = null;
		for (MessageBody msg : (ArrayList<MessageBody>) message.getBodies()) {
			String targetURI = msg.getTargetURI();

			if (targetURI.endsWith(MessageIOConstants.RESULT_METHOD)) {
				if("inactive".equalsIgnoreCase("")){
				Object rest[] = (Object[])msg.getData();
				Map<String,Object> res = (HashMap<String,Object>)rest[0];
				Iterator iter = res.entrySet().iterator();
				while (iter.hasNext()) {
				    Map.Entry entry = (Map.Entry) iter.next();
				    Object key = entry.getKey();
				    Object val = entry.getValue();
				    System.out.println("key："+key+"---其值是："+val);
				} 
				}
				else result = msg.getData();
			} else if (targetURI.endsWith(MessageIOConstants.STATUS_METHOD)) {
				String exMessage = "Server error";
				result = exMessage;
			}
		}
		System.out.println(result);
		outputStream.close();
	}
	
	@SuppressWarnings("unchecked")
	public void testOnlineTimeAward2() throws ClassNotFoundException, IOException {
		SerializationContext serializationContext = new SerializationContext();
		URL url = new URL("http://index.baidu.com/gateway.php");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-amf");
		conn.setRequestProperty("Referer", "http://index.baidu.com/fla/TrendAnalyser.swf");
//		conn.setRequestProperty("Host", "index.baidu.com");
//		conn.setRequestProperty("Cookie", "BAIDUID=21F1C4701464833E6DE5B1A44CA50CBC:FG=1; BDUSS=TFJeGxLbFFmZnFaWnZaMUFZZkpGRXdMbXRQcnZIUFA4RkVGY3EtODFrcDdnbzFOQUFBQUFBJCQAAAAAAAAAAApBLZ8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADEwLjM2LjE5LjQ1AAAAAADgTQ0kAAAAAHv1ZU179WVNb");  
		conn.connect();
		OutputStream outputStream = conn.getOutputStream();

		ActionContext actionContext = new ActionContext();
		ActionMessage requestMessage = new ActionMessage(3);

		List array = new ArrayList();
		array.add(0,"保险");
		array.add(1,"0");
		array.add(2,"2011-01-27|2011-02-25");
		MessageBody messageBody = new MessageBody("DataAccessor.getNews", "/1",
				new Object[]{"保险","0","2011-01-27|2011-02-25"});
//		array.add(0,"保险");
//		array.add(1,"0");
//		array.add(2,"");
//		array.add(3,"");
//		array.add(4,"");
//		MessageBody messageBody = new MessageBody("DataAccessor.getIndexes", "/1",
//				array);
		requestMessage.addBody(messageBody);
		actionContext.setRequestMessage(requestMessage);

		ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();
		AmfMessageSerializer amfMessageSerializer = new AmfMessageSerializer();
		amfMessageSerializer.initialize(serializationContext, outBuffer, null);
		amfMessageSerializer.writeMessage(requestMessage);

		outBuffer.writeTo(outputStream);
		outBuffer.flush();
		outBuffer.close();

		InputStream inputStream = conn.getInputStream();
		BufferedInputStream urlConnectionInputStream = new BufferedInputStream(
				inputStream);
		urlConnectionInputStream.mark(2);
		ActionMessage message = new ActionMessage(3);
		actionContext.setRequestMessage(message);
		MessageDeserializer deserializer = new AmfMessageDeserializer();
		deserializer.initialize(serializationContext, urlConnectionInputStream,
				null);
		deserializer.readMessage(message, actionContext);
		Object result = null;
		for (MessageBody msg : (ArrayList<MessageBody>) message.getBodies()) {
			String targetURI = msg.getTargetURI();

			if (targetURI.endsWith(MessageIOConstants.RESULT_METHOD)) {
				Object[] rest = (Object[])msg.getData();
				System.out.println(rest);
				Map<String,Object> res = (HashMap<String,Object>)rest[0];
				Iterator iter = res.entrySet().iterator();
				while (iter.hasNext()) {
				    Map.Entry entry = (Map.Entry) iter.next();
				    Object key = entry.getKey();
				    Object val = entry.getValue();
				    System.out.println("key："+key+"---其值是："+val);
				    if("news".equalsIgnoreCase(key.toString())){
				    	Object[] nws = (Object[])val;
				    	for(Object obj :nws){
				    	Map<String,Object> news = (HashMap<String,Object>)obj;
				    	iter = news.entrySet().iterator();
				    	while (iter.hasNext()) {
						    entry = (Map.Entry) iter.next();
						    key = entry.getKey();
						    val = entry.getValue();
						    System.out.println("新闻内容：key："+key+"---其值是："+val);
				    	}
				    	}
				    }
				} 
			} else if (targetURI.endsWith(MessageIOConstants.STATUS_METHOD)) {
				String exMessage = "Server error";
				result = exMessage;
			}
		}
//		System.out.println(result);
		outputStream.close();
	}
	
	public static String message(Object bean) {  
		 if (bean == null)  
		     return "对象为空!";  
		 StringBuffer sbf = new StringBuffer();  
		 Class<?> clazz = bean.getClass();  
		 sbf.append("\n" + clazz.getName() + " 检查开始:\n");  
		 try {  
		     sbf.append("  检查公共成员变量：\n");  
		     Field[] fs = clazz.getFields();  
		     for (int i = 0; i < fs.length; i++) {  
		         Field f = fs[i];  
		         sbf.append("    " + clazz.getName() + "." + f.getName() + ": "  
		                 + f.get(bean) + "\n");  
		     }  
		     sbf.append("  检查公共方法：\n");  
		     Method[] ms = clazz.getMethods();  
		     for (int i = 0; i < ms.length; i++) {  
		         Method m = ms[i];  
		         if ((!m.getReturnType().getName().equals("void") && m  
		                 .getParameterTypes().length == 0)) {  
		             sbf.append("    " + clazz.getName() + "." + m.getName()  
		                     + "(): " + m.invoke(bean) + "\n");  
		         }  
		     }  
		 } catch (SecurityException e) {  
		     e.printStackTrace();  
		 } catch (IllegalArgumentException e) {  
		     e.printStackTrace();  
		 } catch (IllegalAccessException e) {  
		     e.printStackTrace();  
		 } catch (InvocationTargetException e) {  
		     e.printStackTrace();  
		 }  
		 sbf.append(clazz.getName() + " 检查结束!");  
		 return sbf.toString();  
		}  

}