//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * All GJ visitors with no argument must implement this interface.
 */

public interface GJNoArguVisitor<R> {

   //
   // GJ Auto class visitors with no argument
   //

   public R visit(NodeList n);
   public R visit(NodeListOptional n);
   public R visit(NodeOptional n);
   public R visit(NodeSequence n);
   public R visit(NodeToken n);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> ( VariablesAndFunctions() )*
    * f1 -> PMain()
    * f2 -> ( VariablesAndFunctions() )*
    * f3 -> <EOF>
    */
   public R visit(Goal n);

   /**
    * f0 -> DeclarationStmt()
    *       | FunctionDeclaration()
    *       | StructDeclaration()
    *       | EnumDeclaration()
    *       | FunctionDefinition()
    *       | TypeDef()
    */
   public R visit(VariablesAndFunctions n);

   /**
    * f0 -> BaseType()
    * f1 -> ObjectList()
    * f2 -> ";"
    */
   public R visit(DeclarationStmt n);

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> [ ArgList() ]
    * f4 -> ")"
    * f5 -> SimpleBlock()
    */
   public R visit(FunctionDefinition n);

   /**
    * f0 -> "{"
    * f1 -> ( DeclarationStmt() )*
    * f2 -> ( StatementUnit() )*
    * f3 -> "}"
    */
   public R visit(SimpleBlock n);

   /**
    * f0 -> Label()
    * f1 -> Statement()
    * f2 -> [ GotoStmt() ]
    */
   public R visit(StatementUnit n);

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> [ ParameterList() ]
    * f4 -> ")"
    * f5 -> ";"
    */
   public R visit(FunctionDeclaration n);

   /**
    * f0 -> ParameterDeclaration()
    * f1 -> ( "," ParameterDeclaration() )*
    */
   public R visit(ParameterList n);

   /**
    * f0 -> Type()
    * f1 -> [ Identifier() ]
    */
   public R visit(ParameterDeclaration n);

   /**
    * f0 -> <STRUCT>
    * f1 -> [ Identifier() ]
    * f2 -> "{"
    * f3 -> ( DeclarationStmt() )*
    * f4 -> "}"
    * f5 -> ";"
    */
   public R visit(StructDeclaration n);

   /**
    * f0 -> <TYPEDEF>
    * f1 -> Type()
    * f2 -> Identifier()
    * f3 -> ";"
    */
   public R visit(TypeDef n);

   /**
    * f0 -> <ENUM>
    * f1 -> Identifier()
    * f2 -> "{"
    * f3 -> Identifier()
    * f4 -> ( "," Identifier() )*
    * f5 -> "}"
    * f6 -> ";"
    */
   public R visit(EnumDeclaration n);

   /**
    * f0 -> MainReturnType()
    * f1 -> <MAIN>
    * f2 -> "("
    * f3 -> [ <INT> Identifier() "," <CHAR> "*" [ "*" ] Identifier() [ "[" "]" ] ]
    * f4 -> ")"
    * f5 -> SimpleBlock()
    */
   public R visit(PMain n);

   /**
    * f0 -> BaseType()
    * f1 -> ( "*" )*
    */
   public R visit(Type n);

   /**
    * f0 -> [ StorageClass() ]
    * f1 -> TypeSpecifier()
    */
   public R visit(BaseType n);

   /**
    * f0 -> <STATIC>
    */
   public R visit(StorageClass n);

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
   public R visit(TypeSpecifier n);

   /**
    * f0 -> Arg()
    * f1 -> ( "," Arg() )*
    */
   public R visit(ArgList n);

   /**
    * f0 -> Type()
    * f1 -> [ Identifier() ]
    */
   public R visit(Arg n);

   /**
    * f0 -> <INT>
    *       | <VOID>
    */
   public R visit(MainReturnType n);

   /**
    * f0 -> ObjectType()
    * f1 -> ( "," ObjectType() )*
    */
   public R visit(ObjectList n);

   /**
    * f0 -> ( "*" )*
    * f1 -> Identifier()
    * f2 -> ( "[" Expression() "]" )*
    * f3 -> [ "=" Expression() ]
    */
   public R visit(ObjectType n);

   /**
    * f0 -> "{"
    * f1 -> StatementList()
    * f2 -> "}"
    */
   public R visit(Block n);

   /**
    * f0 -> ( [ Label() ] Statement() )*
    */
   public R visit(StatementList n);

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
   public R visit(Statement n);

   /**
    * f0 -> <GOTO>
    * f1 -> Identifier()
    * f2 -> ";"
    */
   public R visit(GotoStmt n);

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
   public R visit(ForLoop n);

   /**
    * f0 -> <WHILE>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public R visit(WhileLoop n);

   /**
    * f0 -> <DO>
    * f1 -> Statement()
    * f2 -> <WHILE>
    * f3 -> "("
    * f4 -> Expression()
    * f5 -> ")"
    * f6 -> ";"
    */
   public R visit(DoWhile n);

   /**
    * f0 -> <BREAK>
    * f1 -> ";"
    */
   public R visit(BreakStmt n);

   /**
    * f0 -> <CONTINUE>
    * f1 -> ";"
    */
   public R visit(ContinueStmt n);

   /**
    * f0 -> <RETURN>
    * f1 -> [ Expression() ]
    * f2 -> ";"
    */
   public R visit(ReturnStmt n);

   /**
    * f0 -> IfThenElseStmt()
    *       | IfThenStmt()
    */
   public R visit(IfStmt n);

   /**
    * f0 -> <IF>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public R visit(IfThenStmt n);

   /**
    * f0 -> <IF>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    * f5 -> <ELSE>
    * f6 -> Statement()
    */
   public R visit(IfThenElseStmt n);

   /**
    * f0 -> <SWITCH>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> "{"
    * f5 -> ( CaseStmt() )*
    * f6 -> "}"
    */
   public R visit(SwitchStmt n);

   /**
    * f0 -> <CASE> Expression() ":" ( Statement() )*
    *       | <DFLT> ":" ( Statement() )*
    */
   public R visit(CaseStmt n);

   /**
    * f0 -> Identifier()
    * f1 -> ":"
    */
   public R visit(Label n);

   /**
    * f0 -> Ops()
    * f1 -> PrimaryExpr()
    */
   public R visit(BinOp n);

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
   public R visit(Ops n);

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
   public R visit(LeftUnary n);

   /**
    * f0 -> "++"
    *       | "--"
    */
   public R visit(RightUnary n);

   /**
    * f0 -> PrimaryExpr() [ ExpressionContd() ]
    *       | LeftUnary() PrimaryExpr()
    */
   public R visit(Expression n);

   /**
    * f0 -> RHSAssignExpr()
    *       | "(" [ Expression() ( "," Expression() )* ] ")"
    *       | BinOp()
    *       | RightUnary()
    *       | StructExpr()
    *       | ArrayLookup()
    *       | TernaryExpr()
    */
   public R visit(ExpressionContd n);

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
   public R visit(RHSAssignExpr n);

   /**
    * f0 -> "?"
    * f1 -> Expression()
    * f2 -> ":"
    * f3 -> Expression()
    */
   public R visit(TernaryExpr n);

   /**
    * f0 -> ( "[" PrimaryExpr() "]" )+
    */
   public R visit(ArrayLookup n);

   /**
    * f0 -> StructOps()
    * f1 -> Identifier()
    */
   public R visit(StructExpr n);

   /**
    * f0 -> "->"
    *       | "."
    */
   public R visit(StructOps n);

   /**
    * f0 -> Identifier()
    *       | "(" Expression() ")"
    *       | <INTEGER_LITERAL>
    *       | <FLOATING_POINT_LITERAL>
    *       | <STRING_LITERAL>
    *       | <CHARACTER_LITERAL>
    */
   public R visit(PrimaryExpr n);

   /**
    * f0 -> <IDENTIFIER>
    */
   public R visit(Identifier n);

}

