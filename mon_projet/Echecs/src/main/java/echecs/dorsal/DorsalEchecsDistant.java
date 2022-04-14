package echecs.dorsal;

import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.backend.RemoteBackendNtro;
import echecs.Declarations;

public class DorsalEchecsDistant extends RemoteBackendNtro{

	@Override
	public void registerServer(ServerRegistrar registrar) {
		// TODO Auto-generated method stub
		Declarations.declarerServeur(registrar);
	}

}
