//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class Translator extends GJNoArguDepthFirst<String> {
   public HashSet<String> used;
   
   ArrayList<String> entryStack = new ArrayList<String>();
   ArrayList<String> exitStack  = new ArrayList<String>();
   
   boolean blockUnwind = false;
   boolean switchUnwind  = false;
   boolean whileUnwind = false;
   
   String caseAccumulator="";
   
   private static String generateRandom(String aToZ, int size) {
	    Random rand=new Random();
	    StringBuilder res=new StringBuilder();
	    for (int i = 0; i < size; i++) {
	       int randIndex=rand.nextInt(aToZ.length()); 
	       res.append(aToZ.charAt(randIndex));            
	    }
	    return res.toString();
	}
  
   String genNewLabel(){
	   String all = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	   return "L" + generateRandom("012345", 1) + generateRandom(all, 5);
   }
   
   String genName(){
	   while(true){
		   String s = genNewLabel();
		   if(!used.contains(s)){
			   used.add(s);
			   return s;
		   }
	   }
   }
   
   void pushEntryExit(String entry, String exit){
	   entryStack.add(entry);
	   exitStack.add(exit);
   }
   
   void popEntryExit(){
	   entryStack.remove(entryStack.size()-1);
	   exitStack.remove(exitStack.size()-1);
   }
   
   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public String visit(NodeList n) {
      String _ret="";
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         _ret += e.nextElement().accept(this);
         _count++;
      }
      return _ret;
   }

   public String visit(NodeListOptional n) {
      boolean flag = blockUnwind;
      blockUnwind = false;
      
      boolean switchflag = switchUnwind;

      if ( n.present() ) {
         String _ret="";
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
        	 if(switchflag) 	switchUnwind = true;
        	 _ret += e.nextElement().accept(this);
        	 if(flag){
        		 String s = genName();
        		 _ret += "goto " + s + ";" + s + ":";
        	 }
            _count++;
         }
         return _ret;
      }
      else
         return "";
   }

   public String visit(NodeOptional n) {
      if ( n.present() )
         return n.node.accept(this);
      else
         return "";
   }

   public String visit(NodeSequence n) {
      String _ret="";
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
    	  _ret += e.nextElement().accept(this);
         _count++;
      }
      return _ret;
   }

   public String visit(NodeToken n) { return n.tokenImage; }

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> ( VariablesAndFunctions() )*
    * f1 -> PMain()
    * f2 -> ( VariablesAndFunctions() )*
    * f3 -> <EOF>
    */
   public String visit(Goal n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      _ret += n.f2.accept(this);
      _ret += n.f3.accept(this);
      return _ret;
   }

   /**
    * f0 -> DeclarationStmt()
    *       | FunctionDeclaration()
    *       | StructDeclaration()
    *       | EnumDeclaration()
    *       | FunctionDefinition()
    *       | TypeDef()
    */
   public String visit(VariablesAndFunctions n) {
      String _ret="";
      _ret += n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> BaseType()
    * f1 -> ObjectList()
    * f2 -> ";"
    */
   public String visit(DeclarationStmt n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      _ret += n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> [ ArgList() ]
    * f4 -> ")"
    * f5 -> SimpleBlock()
    */
   public String visit(FunctionDefinition n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      _ret += n.f2.accept(this);
      _ret += n.f3.accept(this);
      _ret += n.f4.accept(this);
      _ret += n.f5.accept(this);
      return _ret;
   }

   /**
    * f0 -> "{"
    * f1 -> ( DeclarationStmt() )*
    * f2 -> ( StatementUnit() )*
    * f3 -> "}"
    */
   public String visit(SimpleBlock n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      _ret += n.f2.accept(this);
      _ret += n.f3.accept(this);
      return _ret;
   }

   /**
    * f0 -> Label()
    * f1 -> Statement()
    * f2 -> GotoStmt()
    */
   public String visit(StatementUnit n) {
      String _ret="";
      int choice = n.f1.f0.which;
      if(choice == 0 || choice == 1 || choice == 2 || choice == 5)
    	  pushEntryExit(n.f0.f0.f0.tokenImage, n.f2.f2.tokenImage);
      
      _ret += n.f0.accept(this);
      
      if(choice == 3)	blockUnwind = true;
      if(choice == 5)	switchUnwind = true;
      if(choice == 0 || choice == 1 || choice == 2)	whileUnwind = true;
      
      if(choice == 6)
    	  _ret += "goto " + exitStack.get(exitStack.size()-1) + ";";
      else if(choice == 12)
    	  _ret += "";
      else
    	  _ret += n.f1.accept(this);
      
      if(choice != 11 && choice != 8)
    	  _ret += n.f2.accept(this);
      
      popEntryExit();
      if(choice == 5)	_ret += caseAccumulator;
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> [ ParameterList() ]
    * f4 -> ")"
    * f5 -> ";"
    */
   public String visit(FunctionDeclaration n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      _ret += n.f2.accept(this);
      _ret += n.f3.accept(this);
      _ret += n.f4.accept(this);
      _ret += n.f5.accept(this);
      return _ret;
   }

   /**
    * f0 -> ParameterDeclaration()
    * f1 -> ( "," ParameterDeclaration() )*
    */
   public String visit(ParameterList n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> [ Identifier() ]
    */
   public String visit(ParameterDeclaration n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> <STRUCT>
    * f1 -> [ Identifier() ]
    * f2 -> "{"
    * f3 -> ( DeclarationStmt() )*
    * f4 -> "}"
    * f5 -> ";"
    */
   public String visit(StructDeclaration n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      _ret += n.f2.accept(this);
      _ret += n.f3.accept(this);
      _ret += n.f4.accept(this);
      _ret += n.f5.accept(this);
      return _ret;
   }

   /**
    * f0 -> <TYPEDEF>
    * f1 -> Type()
    * f2 -> Identifier()
    * f3 -> ";"
    */
   public String visit(TypeDef n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      _ret += n.f2.accept(this);
      _ret += n.f3.accept(this);
      return _ret;
   }

   /**
    * f0 -> <ENUM>
    * f1 -> Identifier()
    * f2 -> "{"
    * f3 -> Identifier()
    * f4 -> ( "," Identifier() )*
    * f5 -> "}"
    * f6 -> ";"
    */
   public String visit(EnumDeclaration n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      _ret += n.f2.accept(this);
      _ret += n.f3.accept(this);
      _ret += n.f4.accept(this);
      _ret += n.f5.accept(this);
      _ret += n.f6.accept(this);
      return _ret;
   }

   /**
    * f0 -> MainReturnType()
    * f1 -> <MAIN>
    * f2 -> "("
    * f3 -> [ <INT> Identifier() "," <CHAR> "*" [ "*" ] Identifier() [ "[" "]" ] ]
    * f4 -> ")"
    * f5 -> SimpleBlock()
    */
   public String visit(PMain n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      _ret += n.f2.accept(this);
      _ret += n.f3.accept(this);
      _ret += n.f4.accept(this);
      _ret += n.f5.accept(this);
      return _ret;
   }

   /**
    * f0 -> BaseType()
    * f1 -> ( "*" )*
    */
   public String visit(Type n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> [ StorageClass() ]
    * f1 -> TypeSpecifier()
    */
   public String visit(BaseType n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> <STATIC>
    */
   public String visit(StorageClass n) {
      String _ret="";
      _ret += n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> <INT>
    *       | <VOID>
    *       | <CHAR>
    *       | <SHORT>
    *       | <LONG>
    *       | <FLOAT>
    *       | <DOUBLE>
    *       | <SIGNED>
    *       | <UNSIGNED>
    *       | Identifier()
    *       | <STRUCT> [ Identifier() ] [ "{" ( DeclarationStmt() )* "}" ]
    *       | <ENUM> [ Identifier() ] "{" Identifier() ( "," Identifier() )* "}"
    */
   public String visit(TypeSpecifier n) {
      String _ret="";
      _ret += n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> Arg()
    * f1 -> ( "," Arg() )*
    */
   public String visit(ArgList n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> [ Identifier() ]
    */
   public String visit(Arg n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> <INT>
    *       | <VOID>
    */
   public String visit(MainReturnType n) {
      String _ret="";
      _ret += n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> ObjectType()
    * f1 -> ( "," ObjectType() )*
    */
   public String visit(ObjectList n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( "*" )*
    * f1 -> Identifier()
    * f2 -> ( "[" Expression() "]" )*
    * f3 -> [ "=" Expression() ]
    */
   public String visit(ObjectType n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      _ret += n.f2.accept(this);
      _ret += n.f3.accept(this);
      return _ret;
   }

   /**
    * f0 -> "{"
    * f1 -> StatementList()
    * f2 -> "}"
    */
   public String visit(Block n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      _ret += n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( [ Label() ] Statement() )*
    */
   public String visit(StatementList n) {
      String _ret="";
      _ret += n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> ForLoop()
    *       | WhileLoop()
    *       | DoWhile()
    *       | Block()
    *       | IfStmt()
    *       | SwitchStmt()
    *       | BreakStmt()
    *       | ContinueStmt()
    *       | ReturnStmt()
    *       | DeclarationStmt()
    *       | Expression() ";"
    *       | GotoStmt()
    *       | ";"
    */
   public String visit(Statement n) {
      String _ret="";
      _ret += n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> <GOTO>
    * f1 -> Label()
    * f2 -> ";"
    */
   public String visit(GotoStmt n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      _ret += n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> <FOR>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ";"
    * f4 -> Expression()
    * f5 -> ";"
    * f6 -> Expression()
    * f7 -> ")"
    * f8 -> Statement()
    */
   public String visit(ForLoop n) {
      String _ret="";
      if(whileUnwind){
    	  String s1 = genName();
    	  String s2 = genName();
    	  String s3 = genName();
    	  
    	  _ret += n.f2.accept(this) + "goto " + s1 + ";";
    	  _ret += s1 + ": if(" + n.f4.accept(this) + ") goto " + s2 + "; else goto " + exitStack.get(exitStack.size()-1) + ";";
    	  _ret += s1 + ":" + n.f8.accept(this) + "goto " + s3 + ";";
    	  _ret += s3 + ":" + n.f6.accept(this) + s1  +";";    	  
      }
      else{
          _ret += n.f0.accept(this);
          _ret += n.f1.accept(this);
          _ret += n.f2.accept(this);
          _ret += n.f3.accept(this);
          _ret += n.f4.accept(this);
          _ret += n.f5.accept(this);
          _ret += n.f6.accept(this);
          _ret += n.f7.accept(this);
          _ret += n.f8.accept(this);    	  
      }
      return _ret;
   }

   /**
    * f0 -> <WHILE>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public String visit(WhileLoop n) {
	  String _ret="";
	  
	  if(whileUnwind){
		  String newLabel = genName();
		  _ret += "if(" + n.f2.accept(this) + ") goto " + newLabel + "; else goto " + exitStack.get(exitStack.size()-1) + ";";
		  _ret += newLabel + ":" + n.f4.accept(this) + "goto " + entryStack.get(entryStack.size()-1) + ";";
	  }
	  else{
	      _ret += n.f0.accept(this);
	      _ret += n.f1.accept(this);
	      _ret += n.f2.accept(this);
	      _ret += n.f3.accept(this);
	      _ret += n.f4.accept(this);  
	  }
	  return _ret;
   }

   /**
    * f0 -> <DO>
    * f1 -> Statement()
    * f2 -> <WHILE>
    * f3 -> "("
    * f4 -> Expression()
    * f5 -> ")"
    * f6 -> ";"
    */
   public String visit(DoWhile n) {
      String _ret="";
      
      if(whileUnwind){
    	  String newLabel = genName();
    	  String oldEntry = entryStack.get(entryStack.size()-1);
    	  entryStack.add(entryStack.size()-1, newLabel);
    	  
    	  _ret += n.f1.accept(this) + "goto " + newLabel + ";";
    	  _ret += newLabel + ": if(" + n.f4.accept(this) 
    	  			+ ") goto " + oldEntry
    	  			+ "; else goto " + exitStack.get(exitStack.size()-1) + ";";	
      }
      else{
          _ret += n.f0.accept(this);
          _ret += n.f1.accept(this);
          _ret += n.f2.accept(this);
          _ret += n.f3.accept(this);
          _ret += n.f4.accept(this);
          _ret += n.f5.accept(this);
          _ret += n.f6.accept(this);
      }
      return _ret;
   }

   /**
    * f0 -> <BREAK>
    * f1 -> ";"
    */
   public String visit(BreakStmt n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> <CONTINUE>
    * f1 -> ";"
    */
   public String visit(ContinueStmt n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> <RETURN>
    * f1 -> [ Expression() ]
    * f2 -> ";"
    */
   public String visit(ReturnStmt n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      _ret += n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> IfThenElseStmt()
    *       | IfThenStmt()
    */
   public String visit(IfStmt n) {
      String _ret="";
      _ret += n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> <IF>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public String visit(IfThenStmt n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      _ret += n.f2.accept(this);
      _ret += n.f3.accept(this);
      _ret += n.f4.accept(this);
      return _ret;
   }

   /**
    * f0 -> <IF>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    * f5 -> <ELSE>
    * f6 -> Statement()
    */
   public String visit(IfThenElseStmt n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      _ret += n.f2.accept(this);
      _ret += n.f3.accept(this);
      _ret += n.f4.accept(this);
      _ret += n.f5.accept(this);
      _ret += n.f6.accept(this);
      return _ret;
   }

   /**
    * f0 -> <SWITCH>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> "{"
    * f5 -> ( CaseStmt() )*
    * f6 -> "}"
    */
   public String visit(SwitchStmt n) {
       boolean flag = switchUnwind;
	   
       String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      _ret += n.f2.accept(this);
      _ret += n.f3.accept(this);
      _ret += n.f4.accept(this);
      _ret += n.f5.accept(this);
      _ret += n.f6.accept(this);
      return _ret;
   }

   /**
    * f0 -> <CASE> Expression() ":" ( Statement() )*
    *       | <DFLT> ":" ( Statement() )*
    */
   public String visit(CaseStmt n) {
      boolean flag = switchUnwind;
      switchUnwind = false;
	   
	  String _ret="";
      if(flag){
    	  String newLabel = genName();
    	  int choice = n.f0.which;
    	  if(choice == 1){
    		  _ret += "case " + ((Expression)((NodeSequence)n.f0.choice).elementAt(1)).accept(this) + ":" + "goto " + newLabel + ";";
    		  caseAccumulator += newLabel + ":" + ((NodeListOptional)((NodeSequence)n.f0.choice).elementAt(3)).accept(this) + "goto " + exitStack.get(exitStack.size()-1) + ";";
    	  }
    	  else{
    		  _ret += "default " + ":" + "goto " + newLabel + ";";
    		  caseAccumulator += newLabel + ":" + ((NodeListOptional)((NodeSequence)n.f0.choice).elementAt(2)).accept(this) + "goto " + exitStack.get(exitStack.size()-1) + ";";
    	  }
      }
      else{
    	  n.f0.accept(this);    	  
      }
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> ":"
    */
   public String visit(Label n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> Ops()
    * f1 -> PrimaryExpr()
    */
   public String visit(BinOp n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> "||"
    *       | "&&"
    *       | "<"
    *       | "<="
    *       | ">"
    *       | ">="
    *       | "=="
    *       | "!="
    *       | "+"
    *       | "-"
    *       | "*"
    *       | "/"
    *       | "%"
    *       | "&"
    *       | "|"
    *       | "^"
    *       | "<<"
    *       | ">>"
    */
   public String visit(Ops n) {
      String _ret="";
      _ret += n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "++"
    *       | "!"
    *       | "--"
    *       | "-"
    *       | "+"
    *       | "~"
    *       | "*"
    *       | "&"
    *       | "(" Type() ")"
    */
   public String visit(LeftUnary n) {
      String _ret="";
      _ret += n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "++"
    *       | "--"
    */
   public String visit(RightUnary n) {
      String _ret="";
      _ret += n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpr() [ ExpressionContd() ]
    *       | LeftUnary() PrimaryExpr()
    */
   public String visit(Expression n) {
      String _ret="";
      if(n.f0.which == 1 && ((NodeToken)((LeftUnary)((NodeSequence)n.f0.choice).elementAt(0)).f0.choice).tokenImage == "++"){
    	  _ret = "(" + ((PrimaryExpr)((NodeSequence)n.f0.choice).elementAt(1)).accept(this) + "+=1)";
      }
      else if(n.f0.which == 1 && ((NodeToken)((LeftUnary)((NodeSequence)n.f0.choice).elementAt(0)).f0.choice).tokenImage == "--"){
    	  _ret = "(" + ((PrimaryExpr)((NodeSequence)n.f0.choice).elementAt(1)).accept(this) + "-=1)";
      }
      else if(n.f0.which == 0 && ((NodeOptional)((NodeSequence)n.f0.choice).elementAt(1)).present() 
    		  && ((ExpressionContd)((NodeOptional)((NodeSequence)n.f0.choice).elementAt(1)).node).f0.which == 3){
    	  
    	  String symbol;
    	  if(((NodeToken)((RightUnary)((ExpressionContd)((NodeOptional)((NodeSequence)n.f0.choice).elementAt(1)).node).f0.choice).f0.choice).tokenImage == "++")
    		  symbol = "+";
    	  else 
    		  symbol = "-";
		   
    	  _ret = "(t=&"+ ((PrimaryExpr)((NodeSequence)n.f0.choice).elementAt(0)).accept(this) + ",t=*p,*p" + symbol + "=1,t)";
      }
      else if(n.f0.which == 0 && ((ExpressionContd)((NodeSequence)n.f0.choice).elementAt(1)).f0.which == 1 
    		  && ((RHSAssignExpr)((ExpressionContd)((NodeSequence)n.f0.choice).elementAt(1)).f0.choice).f0.which != 0 ){
    	  String rhs = ((Expression)((NodeSequence)((RHSAssignExpr)((ExpressionContd)((NodeSequence)n.f0.choice).elementAt(1)).f0.choice).f0.choice).elementAt(1)).accept(this);
    	  String lhs = ((PrimaryExpr)((NodeSequence)n.f0.choice).elementAt(0)).accept(this);
    	  String op = ((NodeToken)((NodeSequence)((RHSAssignExpr)((ExpressionContd)((NodeSequence)n.f0.choice).elementAt(1)).f0.choice).f0.choice).elementAt(0)).tokenImage;
    	  _ret = "(p=&" + lhs + ",*p=*p" + op + rhs + ")";
      }
      else{
    	  _ret += n.f0.accept(this);
      }
      
      return _ret;
   }

   /**
    * f0 -> RHSAssignExpr()
    *       | "(" [ Expression() ( "," Expression() )* ] ")"
    *       | BinOp()
    *       | RightUnary()
    *       | StructExpr()
    *       | ArrayLookup()
    *       | TernaryExpr()
    */
   public String visit(ExpressionContd n) {
      String _ret="";
      _ret += n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "=" Expression()
    *       | "+=" Expression()
    *       | "-=" Expression()
    *       | "*=" Expression()
    *       | "/=" Expression()
    *       | "%=" Expression()
    *       | "<<=" Expression()
    *       | ">>=" Expression()
    *       | "&=" Expression()
    *       | "^=" Expression()
    *       | "|=" Expression()
    */
   public String visit(RHSAssignExpr n) {
      String _ret="";
      _ret += n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "?"
    * f1 -> Expression()
    * f2 -> ":"
    * f3 -> Expression()
    */
   public String visit(TernaryExpr n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      _ret += n.f2.accept(this);
      _ret += n.f3.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( "[" PrimaryExpr() "]" )+
    */
   public String visit(ArrayLookup n) {
      String _ret="";
      _ret += n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> StructOps()
    * f1 -> Identifier()
    */
   public String visit(StructExpr n) {
      String _ret="";
      _ret += n.f0.accept(this);
      _ret += n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> "->"
    *       | "."
    */
   public String visit(StructOps n) {
      String _ret="";
      _ret += n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    *       | "(" Expression() ")"
    *       | <INTEGER_LITERAL>
    *       | <FLOATING_POINT_LITERAL>
    *       | <STRING_LITERAL>
    *       | <CHARACTER_LITERAL>
    */
   public String visit(PrimaryExpr n) {
      String _ret="";
      _ret += n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public String visit(Identifier n) {
      String _ret="";
      _ret += n.f0.accept(this);
      return _ret;
   }

}