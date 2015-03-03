namespace java CoreNLP
namespace py corenlp

struct NamedEntity
{
	1:string entity,
	2:string tag,
	3:i32 startOffset,
	4:i32 endOffset,
	5:i32 sentence_number
}

service StanfordCoreNLPService
{
	string ping(),
	set<string> get_entities(1:string text)
}
