from tenacity import retry, stop_after_attempt, wait_exponential
import requests

class CalculadoraRest:
    def __init__(self, base_url):
        self.base_url = base_url
        
    @retry(stop=stop_after_attempt(3), wait=wait_exponential(multiplier=1))
    def op_escolhida(self, operacao, p1, p2):
        url = f"{self.base_url}/{operacao}/{p1}/{p2}"
        print(f"Fazendo requisição para: {url}")
        resp = requests.post(url, timeout=5)
        resp.raise_for_status()
        return resp.json()

    def soma(self, a, b):
        return self.op_escolhida("soma", a, b)

    def subtracao(self, a, b):
        return self.op_escolhida("subtracao", a, b)

    def multiplicacao(self, a, b):
        return self.op_escolhida("multiplicacao", a, b)

    def divisao(self, a, b):
        if b == 0:
            return {"error": "Divisão por zero"}
        return self.op_escolhida("divisao", a, b)

if __name__ == "__main__":
    calc = CalculadoraRest("http://localhost:8080/operation")
    
    print("Testando calculadora REST...")
    try:
        print("Soma:", calc.soma(5, 3))
        print("Subtração:", calc.subtracao(10, 4))
        print("Multiplicação:", calc.multiplicacao(6, 7))
        print("Divisão:", calc.divisao(20, 4))
        print("Divisão por zero:", calc.divisao(20, 0))
    except Exception as e:
        print(f"Erro: {e}")