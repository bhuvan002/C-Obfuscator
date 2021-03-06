//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * All void visitors must implement this interface.
 */

public interface Visitor {

   //
   // void Auto class visitors
   //

   public void visit(NodeList n);
   public void visit(NodeListOptional n);
   public void visit(NodeOptional n);
   public void visit(NodeSequence n);
   public void visit(NodeToken n);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> ( VariablesAndFunctions() )*
    * f1 -> PMain()
    * f2 -> ( VariablesAndFunctions() )*
    * f3 -> <EOF>
    */
   public void visit(Goal n);

   /**
    * f0 -> DeclarationStmt()
    *       | FunctionDeclaration()
    *       | StructDeclaration()
    *       | EnumDeclaration()
    *       | FunctionDefinition()
    *       | TypeDef()
    */
   public void visit(VariablesAndFunctions n);

   /**
    * f0 -> BaseType()
    * f1 -> ObjectList()
    * f2 -> ";"
    */
   public void visit(DeclarationStmt n);

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> [ ArgList() ]
    * f4 -> ")"
    * f5 -> SimpleBlock()
    */
   public void visit(FunctionDefinition n);

   /**
    * f0 -> "{"
    * f1 -> ( DeclarationStmt() )*
    * f2 -> ( StatementUnit() )*
    * f3 -> "}"
    */
   public void visit(SimpleBlock n);

   /**
    * f0 -> Label()
    * f1 -> Statement()
    * f2 -> [ GotoStmt() ]
    */
   public void visit(StatementUnit n);

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> [ ParameterList() ]
    * f4 -> ")"
    * f5 -> ";"
    */
   public void visit(FunctionDeclaration n);

   /**
    * f0 -> ParameterDeclaration()
    * f1 -> ( "," ParameterDeclaration() )*
    */
   public void visit(ParameterList n);

   /**
    * f0 -> Type()
    * f1 -> [ Identifier() ]
    */
   public void visit(ParameterDeclaration n);

   /**
    * f0 -> <STRUCT>
    * f1 -> [ Identifier() ]
    * f2 -> "{"
    * f3 -> ( DeclarationStmt() )*
    * f4 -> "}"
    * f5 -> ";"
    */
   public void visit(StructDeclaration n);

   /**
    * f0 -> <TYPEDEF>
    * f1 -> Type()
    * f2 -> Identifier()
    * f3 -> ";"
    */
   public void visit(TypeDef n);

   /**
    * f0 -> <ENUM>
    * f1 -> Identifier()
    * f2 -> "{"
    * f3 -> Identifier()
    * f4 -> ( "," Identifier() )*
    * f5 -> "}"
    * f6 -> ";"
    */
   public void visit(EnumDeclaration n);

   /**
    * f0 -> MainReturnType()
    * f1 -> <MAIN>
    * f2 -> "("
    * f3 -> [ <INT> Identifier() "," <CHAR> "*" [ "*" ] Identifier() [ "[" "]" ] ]
    * f4 -> ")"
    * f5 -> SimpleBlock()
    */
   public void visit(PMain n);

   /**
    * f0 -> BaseType()
    * f1 -> ( "*" )*
    */
   public void visit(Type n);

   /**
    * f0 -> [ StorageClass() ]
    * f1 -> TypeSpecifier()
    */
   public void visit(BaseType n);

   /**
    * f0 -> <STATIC>
    */
   public void visit(StorageClass n);

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
   public void visit(TypeSpecifier n);

   /**
    * f0 -> Arg()
    * f1 -> ( "," Arg() )*
    */
   public void visit(ArgList n);

   /**
    * f0 -> Type()
    * f1 -> [ Identifier() ]
    */
   public void visit(Arg n);

   /**
    * f0 -> <INT>
    *       | <VOID>
    */
   public void visit(MainReturnType n);

   /**
    * f0 -> ObjectType()
    * f1 -> ( "," ObjectType() )*
    */
   public void visit(ObjectList n);

   /**
    * f0 -> ( "*" )*
    * f1 -> Identifier()
    * f2 -> ( "[" Expression() "]" )*
    * f3 -> [ "=" Expression() ]
    */
   public void visit(ObjectType n);

   /**
    * f0 -> "{"
    * f1 -> StatementList()
    * f2 -> "}"
    */
   public void visit(Block n);

   /**
    * f0 -> ( [ Label() ] Statement() )*
    */
   public void visit(StatementList n);

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
   public void visit(Statement n);

   /**
    * f0 -> <GOTO>
    * f1 -> Identifier()
    * f2 -> ";"
    */
   public void visit(GotoStmt n);

   /**
    * f0 -> <FOR>
    * f1 -> "("
    * f2 -> [ Expression() ]
    * f3 -> ";"
    * f4 -> [ Expression() ]
    * f5 -> ";"
    * f6 -> [ Expression() ]
    * f7 -> ")"
    * f8 -> Statement()
    */
   public void visit(ForLoop n);

   /**
    * f0 -> <WHILE>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public void visit(WhileLoop n);

   /**
    * f0 -> <DO>
    * f1 -> Statement()
    * f2 -> <WHILE>
    * f3 -> "("
    * f4 -> Expression()
    * f5 -> ")"
    * f6 -> ";"
    */
   public void visit(DoWhile n);

   /**
    * f0 -> <BREAK>
    * f1 -> ";"
    */
   public void visit(BreakStmt n);

   /**
    * f0 -> <CONTINUE>
    * f1 -> ";"
    */
   public void visit(ContinueStmt n);

   /**
    * f0 -> <RETURN>
    * f1 -> [ Expression() ]
    * f2 -> ";"
    */
   public void visit(ReturnStmt n);

   /**
    * f0 -> IfThenElseStmt()
    *       | IfThenStmt()
    */
   public void visit(IfStmt n);

   /**
    * f0 -> <IF>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public void visit(IfThenStmt n);

   /**
    * f0 -> <IF>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    * f5 -> <ELSE>
    * f6 -> Statement()
    */
   public void visit(IfThenElseStmt n);

   /**
    * f0 -> <SWITCH>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> "{"
    * f5 -> ( CaseStmt() )*
    * f6 -> "}"
    */
   public void visit(SwitchStmt n);

   /**
    * f0 -> <CASE> Expression() ":" ( Statement() )*
    *       | <DFLT> ":" ( Statement() )*
    */
   public void visit(CaseStmt n);

   /**
    * f0 -> Identifier()
    * f1 -> ":"
    */
   public void visit(Label n);

   /**
    * f0 -> Ops()
    * f1 -> PrimaryExpr()
    */
   public void visit(BinOp n);

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
   public void visit(Ops n);

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
   public void visit(LeftUnary n);

   /**
    * f0 -> "++"
    *       | "--"
    */
   public void visit(RightUnary n);

   /**
    * f0 -> PrimaryExpr() [ ExpressionContd() ]
    *       | LeftUnary() PrimaryExpr()
    */
   public void visit(Expression n);

   /**
    * f0 -> RHSAssignExpr()
    *       | "(" [ Expression() ( "," Expression() )* ] ")"
    *       | BinOp()
    *       | RightUnary()
    *       | StructExpr()
    *       | ArrayLookup()
    *       | TernaryExpr()
    */
   public void visit(ExpressionContd n);

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
   public void visit(RHSAssignExpr n);

   /**
    * f0 -> "?"
    * f1 -> Expression()
    * f2 -> ":"
    * f3 -> Expression()
    */
   public void visit(TernaryExpr n);

   /**
    * f0 -> ( "[" PrimaryExpr() "]" )+
    */
   public void visit(ArrayLookup n);

   /**
    * f0 -> StructOps()
    * f1 -> Identifier()
    */
   public void visit(StructExpr n);

   /**
    * f0 -> "->"
    *       | "."
    */
   public void visit(StructOps n);

   /**
    * f0 -> Identifier()
    *       | "(" Expression() ")"
    *       | <INTEGER_LITERAL>
    *       | <FLOATING_POINT_LITERAL>
    *       | <STRING_LITERAL>
    *       | <CHARACTER_LITERAL>
    */
   public void visit(PrimaryExpr n);

   /**
    * f0 -> <IDENTIFIER>
    */
   public void visit(Identifier n);

}

