// Copyright 2010, Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.base.core.action.keywords;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import com.base.core.util.StringUtil;
import com.google.api.adwords.lib.AdWordsService;
import com.google.api.adwords.lib.AdWordsServiceLogger;
import com.google.api.adwords.lib.AdWordsUser;
import com.google.api.adwords.lib.utils.MapUtils;
import com.google.api.adwords.v201008.cm.Keyword;
import com.google.api.adwords.v201008.cm.KeywordMatchType;
import com.google.api.adwords.v201008.cm.Paging;
import com.google.api.adwords.v201008.o.Attribute;
import com.google.api.adwords.v201008.o.AttributeType;
import com.google.api.adwords.v201008.o.IdeaType;
import com.google.api.adwords.v201008.o.KeywordAttribute;
import com.google.api.adwords.v201008.o.KeywordMatchTypeSearchParameter;
import com.google.api.adwords.v201008.o.LongAttribute;
import com.google.api.adwords.v201008.o.RelatedToKeywordSearchParameter;
import com.google.api.adwords.v201008.o.RequestType;
import com.google.api.adwords.v201008.o.SearchParameter;
import com.google.api.adwords.v201008.o.TargetingIdea;
import com.google.api.adwords.v201008.o.TargetingIdeaPage;
import com.google.api.adwords.v201008.o.TargetingIdeaSelector;
import com.google.api.adwords.v201008.o.TargetingIdeaServiceInterface;

/**
 * This example gets keywords related to a seed keyword.
 *
 * Tags: TargetingIdeaService.get
 *
 * @author api.arogal@gmail.com (Adam Rogal)
 */
public class GetRelatedKeywords {
  public static void main(String[] args) throws Exception {
    // Log SOAP XML request and response.
    AdWordsServiceLogger.log();

    // Get AdWordsUser from "~/adwords.properties".
    AdWordsUser user = new AdWordsUser(GetRelatedKeywords.class.getClassLoader().getResource("").getPath().toString()+"adwords.properties");
    // Get the TargetingIdeaService.
    TargetingIdeaServiceInterface targetingIdeaService =
        user.getService(AdWordsService.V201008.TARGETING_IDEA_SERVICE);

    // Create seed keyword.
    Keyword keyword = new Keyword();
    keyword.setText("保险");
    keyword.setMatchType(KeywordMatchType.EXACT);

    // Create selector.
    TargetingIdeaSelector selector = new TargetingIdeaSelector();
    selector.setRequestType(RequestType.IDEAS);
    selector.setIdeaType(IdeaType.KEYWORD);
    selector.setRequestedAttributeTypes(new AttributeType[] {AttributeType.KEYWORD,
        AttributeType.AVERAGE_TARGETED_MONTHLY_SEARCHES});

    // Set selector paging (required for targeting idea serivce).
    Paging paging = new Paging();
    paging.setStartIndex(0);
    paging.setNumberResults(50);
    selector.setPaging(paging);

    // Create related to keyword search parameter.
    RelatedToKeywordSearchParameter relatedToKeywordSearchParameter =
        new RelatedToKeywordSearchParameter();
    relatedToKeywordSearchParameter.setKeywords(new Keyword[] {keyword});

    // Create keyword match type search parameter to ensure unique results.
    KeywordMatchTypeSearchParameter keywordMatchTypeSearchParameter =
        new KeywordMatchTypeSearchParameter();
    keywordMatchTypeSearchParameter.setKeywordMatchTypes(
        new KeywordMatchType[] {KeywordMatchType.EXACT});

    selector.setSearchParameters(
        new SearchParameter[] {relatedToKeywordSearchParameter, keywordMatchTypeSearchParameter});

    // Get related keywords.
    TargetingIdeaPage page = targetingIdeaService.get(selector);

    // Display related keywords.
    if (page.getEntries() != null && page.getEntries().length > 0) {
      for (TargetingIdea targetingIdea : page.getEntries()) {
        Map<AttributeType, Attribute> data = MapUtils.toMap(targetingIdea.getData());
        keyword = ((KeywordAttribute) data.get(AttributeType.KEYWORD)).getValue();
        Long averageMonthlySearches =
            ((LongAttribute) data.get(AttributeType.AVERAGE_TARGETED_MONTHLY_SEARCHES)).getValue();
        System.out.println("打到相关关键词：'" + keyword.getText() + "', match type '"
            + keyword.getMatchType() + "', 它平均每月的查询量是：'"
            + averageMonthlySearches + "' was found.");
//        System.out.println(data.get(AttributeType._KEYWORD_CATEGORY));
      }
    } else {
      System.out.println("No related keywords were found.");
    }
  }
  
  /**
   * 查询相关关键字,返回list数组
   * @param key
   * @param type
   * @return
   * @throws IOException
   * @throws ServiceException
   */
  public List<KeywordInfo> getRelateKeys(String key,KeywordMatchType type ) throws IOException, ServiceException{
  AdWordsServiceLogger.log();

  // Get AdWordsUser from "~/adwords.properties".
  AdWordsUser user = new AdWordsUser(GetRelatedKeywords.class.getClassLoader().getResource("").getPath().toString()+"adwords.properties");
  // Get the TargetingIdeaService.
  TargetingIdeaServiceInterface targetingIdeaService =
      user.getService(AdWordsService.V201008.TARGETING_IDEA_SERVICE);

  // Create seed keyword.
  Keyword keyword = new Keyword();
  keyword.setText(StringUtil.isEmpty(key)?"保险":key);
  keyword.setMatchType(type==null?KeywordMatchType.EXACT:type);

  // Create selector.
  TargetingIdeaSelector selector = new TargetingIdeaSelector();
  selector.setRequestType(RequestType.IDEAS);
  selector.setIdeaType(IdeaType.KEYWORD);
  selector.setRequestedAttributeTypes(new AttributeType[] {AttributeType.KEYWORD,
      AttributeType.AVERAGE_TARGETED_MONTHLY_SEARCHES});

  // Set selector paging (required for targeting idea serivce).
  Paging paging = new Paging();
  paging.setStartIndex(0);
  paging.setNumberResults(20);
  selector.setPaging(paging);

  // Create related to keyword search parameter.
  RelatedToKeywordSearchParameter relatedToKeywordSearchParameter =
      new RelatedToKeywordSearchParameter();
  relatedToKeywordSearchParameter.setKeywords(new Keyword[] {keyword});

  // Create keyword match type search parameter to ensure unique results.
  KeywordMatchTypeSearchParameter keywordMatchTypeSearchParameter =
      new KeywordMatchTypeSearchParameter();
  keywordMatchTypeSearchParameter.setKeywordMatchTypes(
      new KeywordMatchType[] {KeywordMatchType.EXACT});

  selector.setSearchParameters(
      new SearchParameter[] {relatedToKeywordSearchParameter, keywordMatchTypeSearchParameter});

  // Get related keywords.
  TargetingIdeaPage page = targetingIdeaService.get(selector);

  List<KeywordInfo> infos = new ArrayList<KeywordInfo>();
  // Display related keywords.
  if (page.getEntries() != null && page.getEntries().length > 0) {
    for (TargetingIdea targetingIdea : page.getEntries()) {
      Map<AttributeType, Attribute> data = MapUtils.toMap(targetingIdea.getData());
      keyword = ((KeywordAttribute) data.get(AttributeType.KEYWORD)).getValue();
      Long averageMonthlySearches =
          ((LongAttribute) data.get(AttributeType.AVERAGE_TARGETED_MONTHLY_SEARCHES)).getValue();
      KeywordInfo keyw = new KeywordInfo();
      keyw.setKeyword(keyword.getText());
      keyw.setSearchCount(averageMonthlySearches);
      infos.add(keyw);
    }
  } else {
    System.out.println("No related keywords were found.");
  }
  return infos;
  }
}
