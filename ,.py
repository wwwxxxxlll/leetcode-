from elasticsearch import Elasticsearch
client = Elasticsearch(hosts=["127.0.0.1"])
doc_type = "documentarys"
query={
    'query':{
        "multi_match":{
            "query":"Year",  # 指定查询内容，注意：会被分词
            "fields":["name", "information"]  # 指定字段
        }
    }}
result = client.search(index="documentaries",doc_type=doc_type,body=query)
print(result)