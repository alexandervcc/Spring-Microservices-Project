package acc.microservices.shopping.services.interfaces;

import java.util.List;

import acc.microservices.shopping.model.Invoice;

public interface InvoiceService {
  public List<Invoice> findInvoiceAll();

  public Invoice createInvoice(Invoice invoice);

  public Invoice updateInvoice(Invoice invoice);

  public Invoice deleteInvoice(Integer invoiceId);

  public Invoice getInvoice(Integer id);
}
