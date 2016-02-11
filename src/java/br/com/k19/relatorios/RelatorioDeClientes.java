package br.com.k19.relatorios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class RelatorioDeClientes {

    List<Cliente> lista = new ArrayList<Cliente>();
    Cliente c1 = new Cliente();
    Cliente c2 = new Cliente();
    Cliente c3 = new Cliente();

    public RelatorioDeClientes() {
        c1.setNome("Alexandre Macedo");
        c1.setEmail("alexbmac@gmail.com");
        c1.setTelefone("9999-9999");

        c2.setNome("Rafael Cosentino");
        c2.setEmail("cosen@gmail.com");
        c2.setTelefone("8888-8888");
        
        c3.setNome("Daniel Machado");
        c3.setEmail("daniel@gmail.com");
        c3.setTelefone("7777-7777");

        lista.add(c1);
        lista.add(c2);
        lista.add(c3);

    }

    public static void main(String[] args) throws JRException, SQLException {

        System.out.println("Gerando relatório...");
        // lista com os nossos clientes

        // compilacao do JRXML
        JasperReport report = JasperCompileManager
                .compileReport("relatorios/RelatorioClientes.jrxml");

        // preenchimento do relatorio, note que o metodo recebe 3 parametros:
        // 1 - o relatorio
        //
        // 2 - um Map, com parametros que sao passados ao relatorio
        // no momento do preenchimento. No nosso caso eh null, pois nao
        // estamos usando nenhum parametro
        //
        // 3 - o data source. Note que nao devemos passar a lista diretamente,
        // e sim "transformar" em um data source utilizando a classe
        // JRBeanCollectionDataSource
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(new RelatorioDeClientes().getLista()));

        // exportacao do relatorio para outro formato, no caso PDF
        JasperExportManager.exportReportToPdfFile(print, "relatorios/RelatorioClientesJulio.pdf");

        System.out.println("Relatório gerado.");
    }

    public List<Cliente> getLista() {
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
    }

    public Cliente getC1() {
        return c1;
    }

    public void setC1(Cliente c1) {
        this.c1 = c1;
    }

    public Cliente getC2() {
        return c2;
    }

    public void setC2(Cliente c2) {
        this.c2 = c2;
    }

    public Cliente getC3() {
        return c3;
    }

    public void setC3(Cliente c3) {
        this.c3 = c3;
    }
    
    
}
