//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * All GJ void visitors must implement this interface.
 */

public interface GJVoidVisitor<A> {

   //
   // GJ void Auto class visitors
   //

   public void visit(NodeList n, A argu);
   public void visit(NodeListOptional n, A argu);
   public void visit(NodeOptional n, A argu);
   public void visit(NodeSequence n, A argu);
   public void visit(NodeToken n, A argu);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> ( VariablesAndFunctions() )*
    * f1 -> PMain()
    * f2 -> ( VariablesAndFunctions() )*
    * f3 -> <EOF>
    */
   public void visit(Goal n, A argu);

   /**
    * f0 -> DeclarationStmt()
    *       | FunctionDeclaration()
    *       | StructDeclaration()
    *       | EnumDeclaration()
    *       | FunctionDefinition()
    *       | TypeDef()
    */
   public void visit(VariablesAndFunctions n, A argu);

   /**
    * f0 -> BaseType()
    * f1 -> ObjectList()
    * f2 -> ";"
    */
   public void visit(DeclarationStmt n, A argu);

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> [ ArgList() ]
    * f4 -> ")"
    * f5 -> SimpleBlock()
    */
   public void visit(FunctionDefinition n, A argu);

   /**
    * f0 -> "{"
    * f1 -> ( DeclarationStmt() )*
    * f2 -> ( StatementUnit() )*
    * f3 -> "}"
    */
   public void visit(SimpleBlock n, A argu);

   /**
    * f0 -> Label()
    * f1 -> Statement()
    * f2 -> [ GotoStmt() ]
    */
   public void visit(StatementUnit n, A argu);

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> [ ParameterList() ]
    * f4 -> ")"
    * f5 -> ";"
    */
   public void visit(FunctionDeclaration n, A argu);

   /**
    * f0 -> ParameterDeclaration()
    * f1 -> ( "," ParameterDeclaration() )*
    */
   public void visit(ParameterList n, A argu);

   /**
    * f0 -> Type()
    * f1 -> [ Identifier() ]
    */
   public void visit(ParameterDeclaration n, A argu);

   /**
    * f0 -> <STRUCT>
    * f1 -> [ Identifier() ]
    * f2 -> "{"
    * f3 -> ( DeclarationStmt() )*
    * f4 -> "}"
    * f5 -> ";"
    */
   public void visit(StructDeclaration n, A argu);

   /**
    * f0 -> <TYPEDEF>
    * f1 -> Type()
    * f2 -> Identifier()
    * f3 -> ";"
    */
   public void visit(TypeDef n, A argu);

   /**
    * f0 -> <ENUM>
    * f1 -> Identifier()
    * f2 -> "{"
    * f3 -> Identifier()
    * f4 -> ( "," Identifier() )*
    * f5 -> "}"
    * f6 -> ";"
    */
   public void visit(EnumDeclaration n, A argu);

   /**
    * f0 -> MainReturnType()
    * f1 -> <MAIN>
    * f2 -> "("
    * f3 -> [ <INT> Identifier() "," <CHAR> "*" [ "*" ] Identifier() [ "[" "]" ] ]
    * f4 -> ")"
    * f5 -> SimpleBlock()
    */
   public void visit(PMain n, A argu);

   /**
    * f0 -> BaseType()
    * f1 -> ( "*" )*
    */
   public void visit(Type n, A argu);

   /**
    * f0 -> [ StorageClass() ]
    * f1 -> TypeSpecifier()
    */
   public void visit(BaseType n, A argu);

   /**
    * f0 -> <STATIC>
    */
   public void visit(StorageClass n, A argu);

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
   public void visit(TypeSpecifier n, A argu);

   /**
    * f0 -> Arg()
    * f1 -> ( "," Arg() )*
    */
   public void visit(ArgList n, A argu);

   /**
    * f0 -> Type()
    * f1 -> [ Identifier() ]
    */
   public void visit(Arg n, A argu);

   /**
    * f0 -> <INT>
    *       | <VOID>
    */
   public void visit(MainReturnType n, A argu);

   /**
    * f0 -> ObjectType()
    * f1 -> ( "," ObjectType() )*
    */
   public void visit(ObjectList n, A argu);

   /**
    * f0 -> ( "*" )*
    * f1 -> Identifier()
    * f2 -> ( "[" Expression() "]" )*
    * f3 -> [ "=" Expression() ]
    */
   public void visit(ObjectType n, A argu);

   /**
    * f0 -> "{"
    * f1 -> StatementList()
    * f2 -> "}"
    */
   public void visit(Block n, A argu);

   /**
    * f0 -> ( [ Label() ] Statement() )*
    */
   public void visit(StatementList n, A argu);

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
   public void visit(Statement n, A argu);

   /**
    * f0 -> <GOTO>
    * f1 -> Identifier()
    * f2 -> ";"
    */
   public void visit(GotoStmt n, A argu);

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
   public void visit(ForLoop n, A argu);

   /**
    * f0 -> <WHILE>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public void visit(WhileLoop n, A argu);

   /**
    * f0 -> <DO>
    * f1 -> Statement()
    * f2 -> <WHILE>
    * f3 -> "("
    * f4 -> Expression()
    * f5 -> ")"
    * f6 -> ";"
    */
   public void visit(DoWhile n, A argu);

   /**
    * f0 -> <BREAK>
    * f1 -> ";"
    */
   public void visit(BreakStmt n, A argu);

   /**
    * f0 -> <CONTINUE>
    * f1 -> ";"
    */
   public void visit(ContinueStmt n, A argu);

   /**
    * f0 -> <RETURN>
    * f1 -> [ Expression() ]
    * f2 -> ";"
    */
   public void visit(ReturnStmt n, A argu);

   /**
    * f0 -> IfThenElseStmt()
    *       | IfThenStmt()
    */
   public void visit(IfStmt n, A argu);

   /**
    * f0 -> <IF>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public void visit(IfThenStmt n, A argu);

   /**
    * f0 -> <IF>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    * f5 -> <ELSE>
    * f6 -> Statement()
    */
   public void visit(IfThenElseStmt n, A argu);

   /**
    * f0 -> <SWITCH>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> "{"
    * f5 -> ( CaseStmt() )*
    * f6 -> "}"
    */
   public void visit(SwitchStmt n, A argu);

   /**
    * f0 -> <CASE> Expression() ":" ( Statement() )*
    *       | <DFLT> ":" ( Statement() )*
    */
   public void visit(CaseStmt n, A argu);

   /**
    * f0 -> Identifier()
    * f1 -> ":"
    */
   public void visit(Label n, A argu);

   /**
    * f0 -> Ops()
    * f1 -> PrimaryExpr()
    */
   public void visit(BinOp n, A argu);

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
   public void visit(Ops n, A argu);

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
   public void visit(LeftUnary n, A argu);

   /**
    * f0 -> "++"
    *       | "--"
    */
   public void visit(RightUnary n, A argu);

   /**
    * f0 -> PrimaryExpr() [ ExpressionContd() ]
    *       | LeftUnary() PrimaryExpr()
    */
   public void visit(Expression n, A argu);

   /**
    * f0 -> RHSAssignExpr()
    *       | "(" [ Expression() ( "," Expression() )* ] ")"
    *       | BinOp()
    *       | RightUnary()
    *       | StructExpr()
    *       | ArrayLookup()
    *       | TernaryExpr()
    */
   public void visit(ExpressionContd n, A argu);

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
   public void visit(RHSAssignExpr n, A argu);

   /**
    * f0 -> "?"
    * f1 -> Expression()
    * f2 -> ":"
    * f3 -> Expression()
    */
   public void visit(TernaryExpr n, A argu);

   /**
    * f0 -> ( "[" PrimaryExpr() "]" )+
    */
   public void visit(ArrayLookup n, A argu);

   /**
    * f0 -> StructOps()
    * f1 -> Identifier()
    */
   public void visit(StructExpr n, A argu);

   /**
    * f0 -> "->"
    *       | "."
    */
   public void visit(StructOps n, A argu);

   /**
    * f0 -> Identifier()
    *       | "(" Expression() ")"
    *       | <INTEGER_LITERAL>
    *       | <FLOATING_POINT_LITERAL>
    *       | <STRING_LITERAL>
    *       | <CHARACTER_LITERAL>
    */
   public void visit(PrimaryExpr n, A argu);

   /**
    * f0 -> <IDENTIFIER>
    */
   public void visit(Identifier n, A argu);

}

