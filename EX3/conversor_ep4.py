#mapeando os mnemônicos e setando váriaveis x e y
mnm = ("An","nAoB","AnB","zeroL","nAeB","Bn","AxB","ABn","AnoB","nAxB","copiaB","AB","umL","AoBn","AoB","copiaA")
x, y = "", ""

#abrindo arquivos
entrada = open("testeula.ula","r")
saida = open("testeula.hex","w")

#loop que visita as linhas de entrada e converte os valores em expressões
for linha in entrada:
  if (linha[0] == "W"):
    w = ""
    i = 2
    while (linha[i]!=";"):
      w+= linha[i]
      i+=1
    w = str(hex(mnm.index(w)))[2].upper()
    saida.write(x+y+w+"\n")
  elif (linha[0] == "X"):
    x = linha[2]
  elif (linha[0] == "Y"):
    y = linha[2]
    
#fechando arquivos
entrada.close()
saida.close()
