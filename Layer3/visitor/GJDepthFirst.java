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
public class GJDepthFirst<R,A> implements GJVisitor<R,A> {

	private HashSet<String> lineNos;
	private String prevLine;
	private Random rand;
	private char[] alphaNumeric;
	private String startLine;

	private String getNewLine() {
		String temp;
		do{
			temp = "L";
			for (int i=0; i<6; ++i) {
				temp += alphaNumeric[rand.nextInt(36)];
			}
		} while (lineNos.contains(temp));
		lineNos.add(temp);
		return temp;
	}

	public GJDepthFirst() {
		lineNos = new HashSet<String>();
		rand = new Random();
		alphaNumeric = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		prevLine = getNewLine();
		startLine = prevLine;
	}

   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public R visit(NodeList n, A argu) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeListOptional n, A argu) {
      if ( n.present() ) {
         R _ret=null;
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,argu);
            _count++;
         }
         return _ret;
      }
      else
         return null;
   }

   public R visit(NodeOptional n, A argu) {
      if ( n.present() )
         return n.node.accept(this,argu);
      else
         return null;
   }

   public R visit(NodeSequence n, A argu) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeToken n, A argu) { return null; }

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> ( VariablesAndFunctions() )*
    * f1 -> PMain()
    * f2 -> ( VariablesAndFunctions() )*
    * f3 -> <EOF>
    */
   public R visit(Goal n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      Integer second = 1;
      n.f0.accept(this, (A)second);
      n.f1.accept(this, (A)second);
      n.f2.accept(this, (A)second);
      n.f3.accept(this, (A)second);
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
   public R visit(VariablesAndFunctions n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> BaseType()
    * f1 -> ObjectList()
    * f2 -> ";"
    */
   public R visit(DeclarationStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      if ((Integer)argu != 0) {
      	System.out.println(";");
      }
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> [ ArgList() ]
    * f4 -> ")"
    * f5 -> Block()
    */
   public R visit(FunctionDefinition n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      if ((Integer)argu != 0) {
      	System.out.print("(");
	      n.f2.accept(this, argu);
	      n.f3.accept(this, argu);
      	System.out.print(")");
      } else {
	      n.f2.accept(this, argu);
	      n.f3.accept(this, argu);
      }
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
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
   public R visit(FunctionDeclaration n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      if ((Integer)argu != 0) {
      	System.out.print("(");
      }
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      if ((Integer)argu != 0) {
      	System.out.println(");");
      }
      return _ret;
   }

   /**
    * f0 -> ParameterDeclaration()
    * f1 -> ( "," ParameterDeclaration() )*
    */
   public R visit(ParameterList n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      if ((Integer)argu != 0) {
      	int size = n.f1.size();
      	for (int i=0; i<size; ++i) {
      		System.out.print(",");
      		n.f1.elementAt(i).accept(this, argu);
      	}
      } else {
      	n.f1.accept(this, argu);
      }
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> [ Identifier() ]
    */
   public R visit(ParameterDeclaration n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
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
   public R visit(StructDeclaration n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	System.out.print(" struct ");
      	n.f1.accept(this, argu);
      	System.out.print("{");
      	n.f3.accept(this, argu);
      	System.out.println("};");
      } else {
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	      n.f3.accept(this, argu);
	      n.f4.accept(this, argu);
	      n.f5.accept(this, argu);
	  }
      return _ret;
   }

   /**
    * f0 -> <TYPEDEF>
    * f1 -> Type()
    * f2 -> Identifier()
    * f3 -> ";"
    */
   public R visit(TypeDef n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	System.out.print(" typedef ");
      }
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      if ((Integer)argu != 0) {
      	System.out.println(";");
      }
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
   public R visit(EnumDeclaration n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	System.out.print(" enum ");
      	n.f1.accept(this, argu);
      	System.out.print("{");
      	n.f3.accept(this, argu);
      	int size = n.f4.size();
      	for (int i=0; i<size; ++i) {
      		System.out.print(",");
      		n.f4.elementAt(i).accept(this, argu);
      	}
      	System.out.println("};");
      } else {
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	      n.f3.accept(this, argu);
	      n.f4.accept(this, argu);
	      n.f5.accept(this, argu);
	      n.f6.accept(this, argu);
	  }
      return _ret;
   }

   /**
    * f0 -> MainReturnType()
    * f1 -> <MAIN>
    * f2 -> "("
    * f3 -> [ <INT> Identifier() "," <CHAR> "*" [ "*" ] Identifier() [ "[" "]" ] ]
    * f4 -> ")"
    * f5 -> Block()
    */
   public R visit(PMain n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      if ((Integer)argu != 0) {
      	System.out.print(" main (");
      	if (n.f3.present()) {
      		System.out.print(" int ");
      		NodeSequence seq = (NodeSequence)n.f3.node;
      		seq.elementAt(1).accept(this, argu);
      		System.out.print(", char *");
      		if (((NodeOptional)seq.elementAt(5)).present()) {
      			System.out.print("*");
      		}
      		seq.elementAt(6).accept(this, argu);
      		if (((NodeOptional)seq.elementAt(7)).present()) {
      			System.out.print("[]");
      		}
      	}
      	System.out.print(")");
      } else {
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	      n.f3.accept(this, argu);
	      n.f4.accept(this, argu);
	  }
      n.f5.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> BaseType()
    * f1 -> ( "*" )*
    */
   public R visit(Type n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      if ((Integer)argu != 0) {
      	int size = n.f1.size();
      	for (int i=0; i<size; ++i) {
      		System.out.print("*");
      	}
      } else {
	      n.f1.accept(this, argu);
	  }
      return _ret;
   }

   /**
    * f0 -> [ StorageClass() ]
    * f1 -> TypeSpecifier()
    */
   public R visit(BaseType n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> <STATIC>
    */
   public R visit(StorageClass n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      if ((Integer)argu != 0) {
      	System.out.print(" static ");
      }
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
   public R visit(TypeSpecifier n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	if (n.f0.which <= 8) {
      		System.out.print(" "+n.f0.choice.toString()+" ");
      	} else {
      		if (n.f0.which != 9) {
      			System.out.print(" "+((NodeSequence)n.f0.choice).elementAt(0).toString()+" ");
      		}
      		n.f0.accept(this, argu);
      	}
      } else {
      	n.f0.accept(this, argu);
      }
      return _ret;
   }

   /**
    * f0 -> Arg()
    * f1 -> ( "," Arg() )*
    */
   public R visit(ArgList n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      if ((Integer)argu != 0) {
      	int size = n.f1.size();
      	for (int i=0; i<size; ++i) {
      		System.out.print(",");
      		n.f1.elementAt(i).accept(this, argu);
      	}
      } else {
      	n.f1.accept(this, argu);
      }
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> [ Identifier() ]
    */
   public R visit(Arg n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> <INT>
    *       | <VOID>
    */
   public R visit(MainReturnType n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      if ((Integer)argu != 0) {
      	System.out.print(" "+n.f0.choice.toString()+" ");
      }
      return _ret;
   }

   /**
    * f0 -> ObjectType()
    * f1 -> ( "," ObjectType() )*
    */
   public R visit(ObjectList n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      if ((Integer)argu != 0) {
      	int size = n.f1.size();
      	for (int i=0; i<size; ++i) {
      		System.out.print(",");
      		n.f1.elementAt(i).accept(this, argu);
      	}
      } else {
      	n.f1.accept(this, argu);
      }
      return _ret;
   }

   /**
    * f0 -> ( "*" )*
    * f1 -> Identifier()
    * f2 -> ( "[" Expression() "]" )*
    * f3 -> [ "=" Expression() ]
    */
   public R visit(ObjectType n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	int size = n.f0.size();
      	for (int i=0; i<size; ++i) {
      		System.out.print("*");
      	}
      	n.f1.accept(this, argu);
      	int size2 = n.f2.size();
      	for (int i=0; i<size2; ++i) {
      		System.out.print("[");
      		((NodeSequence)n.f2.elementAt(i)).elementAt(1).accept(this, argu);
      		System.out.print("]");
      	}
      	if (n.f3.present()) {
      		System.out.print(" = ");
      		n.f3.accept(this, argu);
      	}
      } else {
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	      n.f3.accept(this, argu);
	  }
      return _ret;
   }

   /**
    * f0 -> "{"
    * f1 -> StatementList()
    * f2 -> "}"
    */
   public R visit(Block n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	Integer arg = (Integer)argu + 1;
      	System.out.println("{");
      	n.f1.accept(this, (A)arg);
      	if (arg == 2) {
      		System.out.println(" "+prevLine+": ;");
      		prevLine = getNewLine();
      	}
      	System.out.println("}");
      } else {
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	  }
      return _ret;
   }

   /**
    * f0 -> ( [ Label() ] Statement() )*
    */
   public R visit(StatementList n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
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
   public R visit(Statement n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	if ((Integer)argu <= 2) {
	      	System.out.print("\n "+prevLine+": ");
	      	prevLine = getNewLine();
	     }
      	String temp = prevLine;
      	if (n.f0.which == 10) {
      		n.f0.choice.accept(this, argu);
      		System.out.println(";");
      	} else if (n.f0.which == 12) {
      		System.out.println(";");
      	} else {
      		n.f0.accept(this, argu);
      	}
      	if ((Integer)argu <= 2) {
      		System.out.println(" goto "+temp+";");
      		prevLine = temp;
      	}
      } else {
      	n.f0.accept(this, argu);
      }
      return _ret;
   }

   /**
    * f0 -> <GOTO>
    * f1 -> Label()
    * f2 -> ";"
    */
   public R visit(GotoStmt n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	System.out.print(" goto ");
      	n.f1.accept(this, argu);
      	System.out.print(";");
      } else {
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	  }
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
   public R visit(ForLoop n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	Integer arg = 3;
      	System.out.print(" for (");
      	n.f2.accept(this, (A)arg);
      	System.out.print(";");
      	n.f4.accept(this, (A)arg);
      	System.out.print(";");
      	n.f6.accept(this, (A)arg);
      	System.out.print(")");
      	n.f8.accept(this, (A)arg);
      } else {
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	      n.f3.accept(this, argu);
	      n.f4.accept(this, argu);
	      n.f5.accept(this, argu);
	      n.f6.accept(this, argu);
	      n.f7.accept(this, argu);
	      n.f8.accept(this, argu);
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
   public R visit(WhileLoop n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	Integer arg = 3;
      	System.out.print(" while (");
      	n.f2.accept(this, (A)arg);
      	System.out.print(")");
      } else {
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	      n.f3.accept(this, argu);
	  }
      n.f4.accept(this, argu);
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
   public R visit(DoWhile n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	Integer arg = 3;
      	System.out.print(" do");
      	n.f1.accept(this, (A)arg);
      	System.out.print(" while (");
      	n.f4.accept(this, (A)arg);
      	System.out.print(");");
      } else {
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	      n.f3.accept(this, argu);
	      n.f4.accept(this, argu);
	      n.f5.accept(this, argu);
	      n.f6.accept(this, argu);
	  }
      return _ret;
   }

   /**
    * f0 -> <BREAK>
    * f1 -> ";"
    */
   public R visit(BreakStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      if ((Integer)argu != 0) {
      	System.out.print(" break;");
      }
      return _ret;
   }

   /**
    * f0 -> <CONTINUE>
    * f1 -> ";"
    */
   public R visit(ContinueStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      if ((Integer)argu != 0) {
      	System.out.print(" continue;");
      }
      return _ret;
   }

   /**
    * f0 -> <RETURN>
    * f1 -> [ Expression() ]
    * f2 -> ";"
    */
   public R visit(ReturnStmt n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	System.out.print(" return ");
      	n.f1.accept(this, argu);
      	System.out.println(";");
      } else {
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
      }
      return _ret;
   }

   /**
    * f0 -> IfThenElseStmt()
    *       | IfThenStmt()
    */
   public R visit(IfStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> <IF>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public R visit(IfThenStmt n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	Integer arg = 3;
      	System.out.print("if( ");
      	n.f2.accept(this, (A)arg);
      	System.out.print(")");
      } else {
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	      n.f3.accept(this, argu);
      }
      n.f4.accept(this, argu);
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
   public R visit(IfThenElseStmt n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	Integer arg = 3;
      		System.out.print("if(");
      		n.f2.accept(this, (A)arg);
      		System.out.print(")");
      		n.f4.accept(this, (A)arg);
      		System.out.print(" else ");
      } else {
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	      n.f3.accept(this, argu);
	      n.f4.accept(this, argu);
	      n.f5.accept(this, argu);	
      }
      n.f6.accept(this, argu);
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
   public R visit(SwitchStmt n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	Integer arg = 3;
      	System.out.print("switch (");
      	n.f2.accept(this, (A)arg);
      	System.out.println(") {");
      	n.f5.accept(this, (A)arg);
      	System.out.println("}");
      } else {
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	      n.f3.accept(this, argu);
	      n.f4.accept(this, argu);
	      n.f5.accept(this, argu);
	      n.f6.accept(this, argu);
	  }
      return _ret;
   }

   /**
    * f0 -> <CASE> Expression() ":" ( Statement() )*
    *       | <DFLT> ":" ( Statement() )*
    */
   public R visit(CaseStmt n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	if (n.f0.which == 0) {
      		System.out.print("CASE ");
      		((NodeSequence)n.f0.choice).elementAt(1).accept(this, argu);
      		System.out.print(":");
      		int size2 = ((NodeSequence)((NodeSequence)n.f0.choice).elementAt(3)).size();
      		NodeSequence temp = (NodeSequence)((NodeSequence)n.f0.choice).elementAt(3);
      		for (int i=0; i<size2; ++i) {
      			temp.elementAt(i).accept(this, argu);
      		}
      	} else {
      		System.out.print("DEFAULT :");
      		int size = ((NodeSequence)((NodeSequence)n.f0.choice).elementAt(2)).size();
      		NodeSequence seq = (NodeSequence)((NodeSequence)n.f0.choice).elementAt(2);
      		for (int i=0; i<size; ++i) {
      			seq.elementAt(i).accept(this, argu);
      		}
      	}
      } else {
      	n.f0.accept(this, argu);
      }
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> ":"
    */
   public R visit(Label n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      if (argu == null) {
      	System.out.print(":");
      }
      return _ret;
   }

   /**
    * f0 -> Ops()
    * f1 -> PrimaryExpr()
    */
   public R visit(BinOp n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
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
   public R visit(Ops n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	System.out.print(n.f0.choice.toString());
      }
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "++"
    *       | "!"
    *       | "--"
    *       | "~"
    *       | "*"
    *       | "&"
    *       | "+"
    *       | "-"
    *       | "(" Type() ")"
    */
   public R visit(LeftUnary n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	if (n.f0.which != 8) {
      		System.out.print(" "+n.f0.choice.toString());
      	} else {
      		System.out.print("(");
      		((NodeSequence)n.f0.choice).elementAt(1).accept(this, argu);
      		System.out.print(") ");
      	}
      } else {
      	n.f0.accept(this, argu);
      }
      return _ret;
   }

   /**
    * f0 -> "++"
    *       | "--"
    */
   public R visit(RightUnary n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	System.out.print(n.f0.choice.toString()+" ");
      }
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpr() [ ExpressionContd() ]
    *       | LeftUnary() PrimaryExpr()
    */
   public R visit(Expression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
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
   public R visit(ExpressionContd n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0 && n.f0.which == 1) {
      	System.out.print(" ( ");
      	NodeOptional temp = (NodeOptional)((NodeSequence)n.f0.choice).elementAt(1); 
      	if (temp.present()) {
      		((NodeSequence)temp.node).elementAt(0).accept(this,argu);
      		NodeListOptional seq = (NodeListOptional)((NodeSequence)temp.node).elementAt(1);
      		int size = seq.size();
      		for (int i=0; i<size; ++i) {
      			System.out.print(",");
      			seq.elementAt(i).accept(this,argu);
      		}
      	}
      	System.out.print(" ) ");
      } else {
      	n.f0.accept(this, argu);
      }
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
   public R visit(RHSAssignExpr n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	System.out.print(" "+((NodeSequence)n.f0.choice).elementAt(0).toString()+" ");
      }
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "?"
    * f1 -> Expression()
    * f2 -> ":"
    * f3 -> Expression()
    */
   public R visit(TernaryExpr n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      if ((Integer)argu != 0) {
      	System.out.print(" ? ");
	    n.f1.accept(this, argu);
	    n.f2.accept(this, argu);
	    System.out.print(" : ");
	    n.f3.accept(this, argu);
      } else {
	    n.f1.accept(this, argu);
	    n.f2.accept(this, argu);
	    n.f3.accept(this, argu);
      }
      return _ret;
   }

   /**
    * f0 -> ( "[" PrimaryExpr() "]" )+
    */
   public R visit(ArrayLookup n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0) {
      	int size = n.f0.size();
      	for (int i=0; i<size; ++i) {
      		System.out.print(" [ ");
      		((NodeSequence)n.f0.elementAt(i)).elementAt(1).accept(this, argu);
      		System.out.print(" ] ");
      	}
      } else {
      	n.f0.accept(this, argu);      	
      }
      return _ret;
   }

   /**
    * f0 -> StructOps()
    * f1 -> Identifier()
    */
   public R visit(StructExpr n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "->"
    *       | "."
    */
   public R visit(StructOps n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      if ((Integer)argu != 0) {
      	System.out.print(n.f0.toString());
      }
      return _ret;
   }

   /**
    * f0 -> Identifier()
    *       | "(" Expression() ")"
    *       | IntegerLiteral()
    *       | FloatingLiteral()
    *       | StringLiteral()
    *       | CharLiteral()
    */
   public R visit(PrimaryExpr n, A argu) {
      R _ret=null;
      if ((Integer)argu != 0 && n.f0.which == 1) {
      	System.out.print(" ( ");
      	n.f0.accept(this, argu);
      	System.out.print(" ) ");
      } else {
      	n.f0.accept(this, argu);
      }
      return _ret;
   }

   /**
    * f0 -> <CHARACTER_LITERAL>
    */
   public R visit(CharLiteral n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      if ((Integer)argu != 0) {
      	System.out.print(" "+n.f0.toString()+" ");
      }
      return _ret;
   }

   /**
    * f0 -> <FLOATING_POINT_LITERAL>
    */
   public R visit(FloatingLiteral n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      if ((Integer)argu != 0) {
      	System.out.print(" "+n.f0.toString()+" ");
      }
      return _ret;
   }

   /**
    * f0 -> <STRING_LITERAL>
    */
   public R visit(StringLiteral n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      if ((Integer)argu != 0) {
      	System.out.print(" "+n.f0.toString()+" ");
      }
      return _ret;
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public R visit(Identifier n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      if ((Integer)argu != 0) {
      	System.out.print(" "+n.f0.toString()+" ");
      } else if ((Integer)argu == 0){
      	lineNos.add(n.f0.toString());
      }
      return _ret;
   }

   /**
    * f0 -> <INTEGER_LITERAL>
    */
   public R visit(IntegerLiteral n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      if ((Integer)argu != 0) {
      	System.out.print(" "+n.f0.toString()+" ");
      }
      return _ret;
   }

}
