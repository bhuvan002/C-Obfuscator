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
public class UsedIdsGen extends DepthFirstVisitor{
   //
   // Auto class visitors--probably don't need to be overridden.
   //
	
   public HashSet<String> used = new HashSet<String>();
   public int maxNestingDepth = 0;
   int currDepth = 0;

   void inc(){
      currDepth += 1;
      if(currDepth > maxNestingDepth)
        maxNestingDepth = currDepth;
   }

   void dec(){
      currDepth -= 1;
   }
	
   public void visit(NodeList n) {
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); )
         e.nextElement().accept(this);
   }

   public void visit(NodeListOptional n) {
      if ( n.present() )
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); )
            e.nextElement().accept(this);
   }

   public void visit(NodeOptional n) {
      if ( n.present() )
         n.node.accept(this);
   }

   public void visit(NodeSequence n) {
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); )
         e.nextElement().accept(this);
   }

   public void visit(NodeToken n) { }

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> ( VariablesAndFunctions() )*
    * f1 -> PMain()
    * f2 -> ( VariablesAndFunctions() )*
    * f3 -> <EOF>
    */
   public void visit(Goal n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
   }

   /**
    * f0 -> DeclarationStmt()
    *       | FunctionDeclaration()
    *       | StructDeclaration()
    *       | EnumDeclaration()
    *       | FunctionDefinition()
    *       | TypeDef()
    */
   public void visit(VariablesAndFunctions n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> BaseType()
    * f1 -> ObjectList()
    * f2 -> ";"
    */
   public void visit(DeclarationStmt n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> [ ArgList() ]
    * f4 -> ")"
    * f5 -> SimpleBlock()
    */
   public void visit(FunctionDefinition n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
   }

   /**
    * f0 -> "{"
    * f1 -> ( DeclarationStmt() )*
    * f2 -> ( StatementUnit() )*
    * f3 -> "}"
    */
   public void visit(SimpleBlock n) {
      inc();
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      dec();
   }

   /**
    * f0 -> Label()
    * f1 -> Statement()
    * f2 -> [GotoStmt()]
    */
   public void visit(StatementUnit n) {
      n.f0.accept(this);
      n.f1.accept(this);
      if(n.f2.present())
    	  n.f2.accept(this);
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> [ ParameterList() ]
    * f4 -> ")"
    * f5 -> ";"
    */
   public void visit(FunctionDeclaration n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
   }

   /**
    * f0 -> ParameterDeclaration()
    * f1 -> ( "," ParameterDeclaration() )*
    */
   public void visit(ParameterList n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> Type()
    * f1 -> [ Identifier() ]
    */
   public void visit(ParameterDeclaration n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> <STRUCT>
    * f1 -> [ Identifier() ]
    * f2 -> "{"
    * f3 -> ( DeclarationStmt() )*
    * f4 -> "}"
    * f5 -> ";"
    */
   public void visit(StructDeclaration n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
   }

   /**
    * f0 -> <TYPEDEF>
    * f1 -> Type()
    * f2 -> Identifier()
    * f3 -> ";"
    */
   public void visit(TypeDef n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
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
   public void visit(EnumDeclaration n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
   }

   /**
    * f0 -> MainReturnType()
    * f1 -> <MAIN>
    * f2 -> "("
    * f3 -> [ <INT> Identifier() "," <CHAR> "*" [ "*" ] Identifier() [ "[" "]" ] ]
    * f4 -> ")"
    * f5 -> SimpleBlock()
    */
   public void visit(PMain n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
   }

   /**
    * f0 -> BaseType()
    * f1 -> ( "*" )*
    */
   public void visit(Type n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> [ StorageClass() ]
    * f1 -> TypeSpecifier()
    */
   public void visit(BaseType n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> <STATIC>
    */
   public void visit(StorageClass n) {
      n.f0.accept(this);
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
   public void visit(TypeSpecifier n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> Arg()
    * f1 -> ( "," Arg() )*
    */
   public void visit(ArgList n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> Type()
    * f1 -> [ Identifier() ]
    */
   public void visit(Arg n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> <INT>
    *       | <VOID>
    */
   public void visit(MainReturnType n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> ObjectType()
    * f1 -> ( "," ObjectType() )*
    */
   public void visit(ObjectList n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> ( "*" )*
    * f1 -> Identifier()
    * f2 -> ( "[" Expression() "]" )*
    * f3 -> [ "=" Expression() ]
    */
   public void visit(ObjectType n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
   }

   /**
    * f0 -> "{"
    * f1 -> StatementList()
    * f2 -> "}"
    */
   public void visit(Block n) {
      inc();
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      dec();
   }

   /**
    * f0 -> ( [ Label() ] Statement() )*
    */
   public void visit(StatementList n) {
      n.f0.accept(this);
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
   public void visit(Statement n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> <GOTO>
    * f1 -> Label()
    * f2 -> ";"
    */
   public void visit(GotoStmt n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
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
   public void visit(ForLoop n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      n.f7.accept(this);
      n.f8.accept(this);
   }

   /**
    * f0 -> <WHILE>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public void visit(WhileLoop n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
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
   public void visit(DoWhile n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
   }

   /**
    * f0 -> <BREAK>
    * f1 -> ";"
    */
   public void visit(BreakStmt n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> <CONTINUE>
    * f1 -> ";"
    */
   public void visit(ContinueStmt n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> <RETURN>
    * f1 -> [ Expression() ]
    * f2 -> ";"
    */
   public void visit(ReturnStmt n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
   }

   /**
    * f0 -> IfThenElseStmt()
    *       | IfThenStmt()
    */
   public void visit(IfStmt n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> <IF>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public void visit(IfThenStmt n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
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
   public void visit(IfThenElseStmt n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
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
   public void visit(SwitchStmt n) {
      inc();
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      dec();
   }

   /**
    * f0 -> <CASE> Expression() ":" ( Statement() )*
    *       | <DFLT> ":" ( Statement() )*
    */
   public void visit(CaseStmt n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> Identifier()
    * f1 -> ":"
    */
   public void visit(Label n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> Ops()
    * f1 -> PrimaryExpr()
    */
   public void visit(BinOp n) {
      n.f0.accept(this);
      n.f1.accept(this);
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
   public void visit(Ops n) {
      n.f0.accept(this);
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
   public void visit(LeftUnary n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> "++"
    *       | "--"
    */
   public void visit(RightUnary n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> PrimaryExpr() [ ExpressionContd() ]
    *       | LeftUnary() PrimaryExpr()
    */
   public void visit(Expression n) {
      n.f0.accept(this);
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
   public void visit(ExpressionContd n) {
      n.f0.accept(this);
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
   public void visit(RHSAssignExpr n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> "?"
    * f1 -> Expression()
    * f2 -> ":"
    * f3 -> Expression()
    */
   public void visit(TernaryExpr n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
   }

   /**
    * f0 -> ( "[" PrimaryExpr() "]" )+
    */
   public void visit(ArrayLookup n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> StructOps()
    * f1 -> Identifier()
    */
   public void visit(StructExpr n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> "->"
    *       | "."
    */
   public void visit(StructOps n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> Identifier()
    *       | "(" Expression() ")"
    *       | <INTEGER_LITERAL>
    *       | <FLOATING_POINT_LITERAL>
    *       | <STRING_LITERAL>
    *       | <CHARACTER_LITERAL>
    */
   public void visit(PrimaryExpr n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public void visit(Identifier n) {
      n.f0.accept(this);
      if(!used.contains(n.f0.tokenImage))
    	  used.add(n.f0.tokenImage);
   }

}
