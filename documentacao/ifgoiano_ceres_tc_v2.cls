%%
% Modelo de documento de TC para o IF Goiano
% Autor: Ronneesley Moura Teles
%%

%Problemas em aberto
%1. Os apêndices devem possuir um hífen no sumário "APÊNDICE A - "

\DeclareOption{versao=digital}{\setboolean{versao}{digital}}

%Nome da classe
\ProvidesClass{ifgoiano_ceres_tc_v2}[24/07/2015]

%Versão do documento
\def\versao#1{\def\@versao{#1}}                	\versao{}

%Por padrão são duas páginas para impressao
\versao{twoside}

%Versão digital retira as páginas extras para impressão
\DeclareOption{versao=digital}{	\versao{oneside} }
%Versão impressao coloca as duas páginas para impressao
\DeclareOption{versao=impressao}{ \versao{twoside} }

%Repassa as demais opções ao abntex2
\DeclareOption*{%
  \PassOptionsToClass{\CurrentOption}{abntex2}%
}
\ProcessOptions\relax

\LoadClass[12pt,
	openright, % capítulos começam em pág ímpar (insere página vazia caso preciso)
	\@versao,  %para impressão em verso e anverso. Oposto a oneside (manual página 16)
	a4paper, % tamanho do papel (manual página 16) 
	chapter=TITLE, % títulos de capítulos convertidos em letras maiúsculas
	section=Title, % títulos de seções convertidos em letras maiúsculas
	subsection=Title, % títulos de subseções convertidos em letras maiúsculas
	sumario=tradicional,
	english, % idioma adicional para hifenização
	brazilian % o último idioma é o principal do documento
	]{abntex2}

%\RequirePackage{rmt}

\RequirePackage[utf8]{inputenc}
\RequirePackage[brazil]{babel}

\RequirePackage[brazilian,hyperpageref]{backref}	 % Paginas com as citações na bibl

%Estilo de escrita das referências bibliográficas
\RequirePackage[alf]{abntex2cite}

\RequirePackage{enumerate}
\RequirePackage{cancel}
\RequirePackage{indentfirst}
\RequirePackage{hyperref}
\RequirePackage{lastpage}			% Usado pela Ficha catalográfica
\RequirePackage{color}				% Controle das cores

\let\footruleskip\undefined %retirada da definição da função que deu conflito
\RequirePackage{fancyhdr}

\RequirePackage{amsmath}
\RequirePackage{amsfonts}
\RequirePackage{amssymb}
\RequirePackage{mathptmx}
\RequirePackage{ifthen}
\RequirePackage{afterpage}
\RequirePackage{microtype} %Melhorias para justificação
\RequirePackage[final]{pdfpages}

%Espeficiação das margens: manual página 16
\RequirePackage[top=3cm, left=3cm, bottom=2cm, right=2cm]{geometry}

%Especifica os tamanhos das fontes
\renewcommand\large{\@setfontsize\large{14pt}{18}}
\renewcommand\Large{\@setfontsize\Large{18pt}{18}}
\renewcommand\LARGE{\@setfontsize\LARGE{21pt}{18}}
\renewcommand\huge{\@setfontsize\huge{25pt}{18}}
\renewcommand\Huge{\@setfontsize\Huge{26pt}{18}}

%Configurações
\renewcommand{\familydefault}{\sfdefault} %Especificação de onte sans serif: arial (manual página 16)

\linespread{1.5} %Espaçamento entre linhas de 1,5 (manual página 16)

\setlength{\parindent}{1.25cm} %Tamanho da tabulação do parágrafo (manual página 16)

\setlength{\ABNTEXcitacaorecuo}{4cm} %Recúo da citação (manual página 16)

\pagenumbering{arabic} %Manual página 17

%Configura o cabeçalho
\renewcommand{\textual}{
	\makepagestyle{plain}
	\pagestyle{plain}
	\aliaspagestyle{chapter}{plain}
	\makeevenfoot{plain}{}{}{\normalfont \thepage}
	\makeoddfoot{plain}{}{}{\normalfont \thepage}
}

\renewcommand{\postextual}{
	\phantompart
	\addtocontents{toc}{\cftpagenumbersoff{chapter}}
}

%Definições do título de capítulo
\makechapterstyle{ifgoiano-ceres}{%
	%Coloca a fonte de tamanho normal (12 pt) e negrita (manual página 16)
	\renewcommand*{\chaptitlefont}{\normalfont \bfseries}	
	%Especifica a mesma fonte para o número do capítulo
	\renewcommand*{\chapnumfont}{\chaptitlefont} 
	
	%Limpa outras formatações
	\renewcommand{\chapterheadstart}{} %Limpa o espaçamento vertical do título
	\renewcommand*{\chapternamenum}{}
	\renewcommand*{\printchaptername}{}
	\renewcommand*{\afterchapternum}{
		\ifthenelse{\boolean{abntex@apendiceousecao}}{–}{}
	}
	
	%Coloca um espaço depois do número do capítulo
	\renewcommand*{\printchapternum}{\chapnumfont \thechapter\space}
	
	% impressao do nome do capitulo
	\renewcommand{\printchaptername}{%
		\chaptitlefont
		\ifthenelse{\boolean{abntex@apendiceousecao}}{\appendixname\space}{}%
	}
	
	%Coloca a letra do título em maiúsculo
	\renewcommand{\printchaptertitle}[1]{%
		\ifthenelse{\boolean{abntex@apendiceousecao}}{
			\chaptitlefont \centering\MakeUppercase{##1}
		}{
			\chaptitlefont \raggedright\MakeUppercase{##1}
		}
	}	
	
	%Quebra uma linha
	\renewcommand{\afterchaptertitle}{%
		\vskip\onelineskip
	}
}

%Especifica o tipo de formatação de capítulo
\chapterstyle{ifgoiano-ceres} 

%Especifica fonte normal e negrita para a seção (manual página 17)
\setsecheadstyle{\normalfont \bfseries}
%Especifica fonte normal para a seção (manual página 17)
\setsubsecheadstyle{\normalfont}

%Define campos preenchíveis para a capa
\def\curso#1{\def\@curso{#1}}                					\curso{}
\def\ano#1{\def\@ano{#1}}                 						\ano{}
\def\uf#1{\def\@uf{#1}}                 						\uf{}
\def\dataDefesa#1{\def\@dataDefesa{#1}}    						\dataDefesa{}
\def\primeiroMembroBanca#1{\def\@primeiroMembroBanca{#1}}		\primeiroMembroBanca{}
\def\segundoMembroBanca#1{\def\@segundoMembroBanca{#1}}			\segundoMembroBanca{}

\def\orientadorInstituicao#1{\def\@orientadorInstituicao{#1}}		\orientadorInstituicao{}
\def\primeiroMembroBancaInstituicao#1{\def\@primeiroMembroBancaInstituicao{#1}}		\primeiroMembroBancaInstituicao{}
\def\segundoMembroBancaInstituicao#1{\def\@segundoMembroBancaInstituicao{#1}}		\segundoMembroBancaInstituicao{}

%Configura a capa, conforme anexo A (pg 31)
\renewcommand{\imprimircapa}{%
	\begin{capa}%
		\normalfont{ 
			{\sffamily
				\center
				\textbf{INSTITUTO FEDERAL GOIANO - CAMPUS CERES}
		
				\textbf{BACHARELADO EM \MakeUppercase{\@curso}}
		
				\textbf{\MakeUppercase{\imprimirautor}}
				\vfill
				\begin{center}
					\bfseries \MakeUppercase{\imprimirtitulo}				
				\end{center}
				
				\vfill
				\begin{center}
					{\bfseries \MakeUppercase{\imprimirlocal\space - \@uf}}		
				
					{\bfseries \@ano}
				\end{center}
			}
		}
	\end{capa}
}

\newcommand\tamanhoDaFonte[1]{
	{#1 tamanho da fonte: \f@size pt\par}
}

%Imprime os tamanhos das fontes
\newcommand{\imprimirTamanhoFontes}{
	tiny: \tamanhoDaFonte\tiny
	scriptsize: \tamanhoDaFonte\scriptsize
	footnotesize: \tamanhoDaFonte\footnotesize
	small: \tamanhoDaFonte\small
	normalsize: \tamanhoDaFonte\normalsize
	large: \tamanhoDaFonte\large
	Large: \tamanhoDaFonte\Large
	LARGE: \tamanhoDaFonte\LARGE
	huge: \tamanhoDaFonte\huge
	Huge:\tamanhoDaFonte\Huge
}

%Configura a folha de rosto
\def\titulacaoCurso#1{\def\@titulacaoCurso{#1}}                \titulacaoCurso{bacharel}

\preambulo{Trabalho de curso apresentado ao curso de \@curso\space do Instituto Federal Goiano – Campus Ceres, como requisito parcial para a obtenção do título de \@titulacaoCurso\space em \@curso, sob orientação do Prof. \imprimirorientador.}

%Conforme o Anexo B (pg 32)
\renewcommand{\folhaderostocontent}{
	\begin{center}
		\normalfont{
			{\sffamily
				\textbf{\MakeUppercase{\imprimirautor}}
				
				\vspace*{\fill}\vspace*{\fill}
				
				\begin{center}
					\bfseries \MakeUppercase{\imprimirtitulo}				
				\end{center}
				
				\vspace*{\fill}
				\abntex@ifnotempty{\imprimirpreambulo}{%
					\hspace{.45\textwidth}
					\begin{minipage}{.5\textwidth}
						\SingleSpacing
						\imprimirpreambulo
					\end{minipage}%
					\vspace*{\fill}
				}%
				
				\vfill
				\begin{center}
					{\bfseries \MakeUppercase{\imprimirlocal\space - \@uf}}		
				
					{\bfseries \@ano}
				\end{center}
			}
		}
	\end{center}
}

%Regula a assinatura
\renewcommand{\assinatura}[2]{
	\begin{center}
		\rule{12cm}{1pt}
	
		#1
		
		#2
	\end{center}
}

\def\fichaCatalografica#1{\def\@fichaCatalografica{#1}}			\fichaCatalografica{}

\newcommand{\imprimirFichaCatalografica}{
	\includepdf[pages=-]{\@fichaCatalografica}
	\cleardoublepage
}

\def\folhaAprovacaoAssinada#1{\def\@folhaAprovacaoAssinada{#1}}			\folhaAprovacaoAssinada{}

\newcommand{\imprimirFolhaAprovacao}{
	\ifthenelse{\equal{\@folhaAprovacaoAssinada}{}}{
		\begin{folhadeaprovacao}
			\begin{center}	
			\normalfont{
				{\sffamily
					\textbf{\MakeUppercase{\imprimirautor}}		
					
					\vfill
					
					\begin{center}
						\bfseries \MakeUppercase{\imprimirtitulo}				
					\end{center}
					
					\vspace*{1\onelineskip}
					
					\abntex@ifnotempty{\imprimirpreambulo}{%
						\hspace{.45\textwidth}
						\begin{minipage}{.5\textwidth}
							\SingleSpacing
							\imprimirpreambulo
						\end{minipage}%
					}%
					
					\vspace*{2\onelineskip}	
					
					\textbf{Banca Examinadora}
					
					\vspace*{1\onelineskip}
					
					\assinatura{\imprimirorientador}{\@orientadorInstituicao} 
					
					\vspace*{1\onelineskip}
					
				   	\assinatura{\@primeiroMembroBanca}{\@primeiroMembroBancaInstituicao}
				   	
				   	\vspace*{1\onelineskip}
				   	
			   		\assinatura{\@segundoMembroBanca}{\@segundoMembroBancaInstituicao}
			   		
					\vspace*{2\onelineskip}		   		
			   		
			   		
			   		\ifthenelse{\equal{\@dataDefesa}{}}{
				   		Aprovada em \underline{\hspace{1cm}}/\underline{\hspace{1cm}}/\underline{\hspace{2cm}}
				   	}{		   		
			   			Aprovada em \@dataDefesa
			   		}
				}
			}		
			\end{center}
		\end{folhadeaprovacao}
		\cleardoublepage
	}{
		\includepdf[pages=-]{\@folhaAprovacaoAssinada}
		\cleardoublepage
	}
}

%Regula ambiente de agradecimentos
\renewenvironment{agradecimentos}{
	\begin{center}
		\textbf{AGRADECIMENTOS}
	\end{center}	
	\vskip\onelineskip
	
	\indent
}{\cleardoublepage}

\newcommand{\configurarInformacoesPDF}{
	\makeatletter
	\hypersetup{
		pdftitle={\imprimirtitulo},
		pdfauthor={\imprimirautor},
		pdfsubject={\imprimirpreambulo},
		pdfkeywords={Trabalho de Curso},
		pdfcreator={LaTeX},
		colorlinks=true,
		linkcolor=black,
		citecolor=black,
		urlcolor=black
	}
	\makeatother
}

\makeindex

\selectlanguage{brazil}

\frenchspacing % Retira espaço extra obsoleto entre as frases.

%Modifica o título das referências para centralizar
\renewcommand*{\bibsection}{%
	%Renomeia a seção de referências
	\renewcommand{\bibname}{\uppercase{Referências}}

	%Modifica os títulos a seguir para centralizado
	\renewcommand{\printchaptertitle}[1]{%
		\chaptitlefont \raggedright \centering \MakeUppercase{##1}
	} 	
	
	\chapter*{\bibname}
	\addcontentsline{toc}{chapter}{\bibname}
	\SingleSpacing
	
	\citeoption{abnt-emphasize=bf}
}

%Coloca uma linha para separar as referências bibliográficas (manual página 24)
\setlength{\bibitemsep}{\onelineskip} 

%Regula o posicionamento dos títulos lof, toc
\renewcommand{\printloftitle}{\centering\bfseries\MakeUppercase} %Anexo I (pg 39)
\renewcommand{\printlottitle}{\centering\bfseries\MakeUppercase} %Anexo J (pg 40)
\renewcommand{\printtoctitle}{\centering\bfseries\MakeUppercase} %pg 9

%Regula ambiente de lista de abreviaturas e siglas (Segue a mesma diretiva dos anexo I e J)
\renewenvironment{siglas}{
	\begin{center}
		\textbf{LISTA DE ABREVIATURAS E SIGLAS}
	\end{center}
	\vskip\onelineskip
	
	\begin{symbols}
}{
	\end{symbols}
	\cleardoublepage
}

%Regula a configuração do sumário
\renewcommand{\cftsectionfont}{\bfseries}	%Seção em negrito
\setlength{\cftsectionindent}{0pt}			%Retira identação da seção
\setlength{\cftsubsectionindent}{0pt}		%Retira identação da subseção
\setlength{\cftsubsubsectionindent}{0pt}	%Retira identação da subsubseção

%Deixa os nomes dos capítulos do sumário maiúsculos também
\makeatletter
\settocpreprocessor{chapter}{%
  		\let\tempf@rtoc\f@rtoc  		
	\def\f@rtoc{
		\texorpdfstring{\MakeTextUppercase{\tempf@rtoc}}{\tempf@rtoc}
	}
}

%Ajusta a parte pós-textual
\renewcommand{\postextual}{\phantompart}
\renewcommand{\phantompart}{%
  \bookmarksetup{startatroot}
}


\makeatother